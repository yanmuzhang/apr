package com.cloud.ccb.context.domain.service.impl;

import cn.liberfree.common.Page;
import cn.liberfree.common.PageResult;
import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.mybatis.PageParames;
import com.cloud.ccb.api.dto.*;
import com.cloud.ccb.context.domain.mappers.dmo.LoginInfoDmo;
import com.cloud.ccb.context.domain.model.*;
import com.cloud.ccb.context.domain.query.LoginInfoQuery;
import com.cloud.ccb.context.domain.query.OperatorQuery;
import com.cloud.ccb.context.domain.service.OperatorService;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-15 14:43
 **/
@Service
public class OperatorServiceImpl implements OperatorService {



    @Autowired
    private EntityLoader entityLoader;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private OperatorQuery openUserQuery;

    @Autowired
    private LoginInfoQuery loginInfoQuery;




    @Override
    public void addOperator(OperatorAddDto userAddDto) {
        if(userAddDto == null){
            throw new BusinessException("userAddDto require");
        }
        if(StringUtils.isEmpty(userAddDto.getPhone())){
            throw new BusinessException("phone require");
        }
        People people = null;
        String peopleId = openUserQuery.getPeopleIdByPhone(userAddDto.getPhone());
        if(StringUtils.isEmpty(peopleId)){
            people = entityLoader.create(People.class);

            Set<LoginInfo> loginInfoSet = new HashSet<>();
            LoginInfo loginInfoPassword = new LoginInfo();
            loginInfoPassword.init(DigestUtils.md5DigestAsHex(LoginInfo.DEFAULT_MARK.getBytes()),LoginInfo.Source.PASSWORD,LoginInfo.Status.BINDING);
            loginInfoSet.add(loginInfoPassword);
            LoginInfo loginInfoPhone = new LoginInfo();
            loginInfoPhone.init(userAddDto.getPhone(),LoginInfo.Source.PHONE,LoginInfo.Status.BINDING);
            loginInfoSet.add(loginInfoPhone);

            people.init(userAddDto.getPhone(),loginInfoSet,null,null);
            people.bindPhone(userAddDto.getPhone());
        }else{
            people = entityLoader.load(peopleId,People.class);
        }

        Optional<Set<OperatorAttrDto>> attrSet = Optional.ofNullable(userAddDto.getAttrSet());
        Set<OperatorAttr> collect = null;
        if(attrSet.isPresent()){
            collect = attrSet.get().stream().map(i -> {
                OperatorAttr openUserAttr = new OperatorAttr();
                openUserAttr.setName(i.getName());
                openUserAttr.setSort(i.getSort());
                openUserAttr.setValue(i.getValue());
                return openUserAttr;
            }).collect(Collectors.toSet());
        }

        Operator operator = entityLoader.create(Operator.class);

        Set<String> roleIds = userAddDto.getRoleIds();
        operator.init(people.getId(),userAddDto.getAppId(),collect,roleIds);
    }

    @Override
    public void updateOperator(OperatorEditDto userDto) {
        Operator operator = entityLoader.load(userDto.getOpenId(), Operator.class);
        Map<String,String> attrMap = userDto.getAttrs();
        for (OperatorAttr openUserAttr : operator.getAttrSet()) {
            for (Map.Entry<String,String> m : attrMap.entrySet()) {
                if(StringUtils.equals(openUserAttr.getName(),m.getKey())){
                    openUserAttr.setValue(m.getValue());
                    break;
                }
            }
        }
        Set<String> roleIds = userDto.getRoleIds();
        operator.editRoles(roleIds);
    }

    @Override
    public void certificationOperator(CertificationDto certificationDto) {
        String peopleId = openUserQuery.getPeopleIdByAppIdAndOpenId(certificationDto.getAppId(),certificationDto.getOpenId());
        People people = entityLoader.load(peopleId, People.class);
        CertificationInfo certificationInfo = new CertificationInfo();
        mapper.map(certificationDto,certificationInfo);
        people.certification(certificationInfo);
    }

    @Override
    public OperatorInfoDto getOperatorInfo(String openId) {
        if(openId == null){
            throw new BusinessException("openId require");
        }


        Operator operator = entityLoader.load(openId, Operator.class);
        if(operator == null){
            return null;
        }
        OperatorInfoDto userInfoDto = new OperatorInfoDto();
        People people = entityLoader.load(operator.getPeopleId(), People.class);
        userInfoDto.setOpenId(openId);
        userInfoDto.setPhone(people.getPhone());
        CertificationInfo certificationInfo = people.getCertificationInfo();
        if(certificationInfo != null){
            CertificationInfoDto certificationInfoDto = mapper.map(certificationInfo, CertificationInfoDto.class);
            userInfoDto.setCertificationInfo(certificationInfoDto);
        }

        Set<OperatorAttr> attrSet = operator.getAttrSet();
        if(attrSet != null){
            userInfoDto.setAttrs(operator.getAttrs());
        }

        Set<String> roles = operator.getRoles();
        if(roles != null){
            Set<RoleDto> collect = roles.stream().map(id -> {
                Role role = entityLoader.load(id, Role.class);
                return mapper.map(role, RoleDto.class);
            }).collect(Collectors.toSet());
            userInfoDto.setRoles(collect);
        }
        return userInfoDto;
    }

    @Override
    public PageResult<OperatorInfoDto> getOperatorList( int pageIndex, int pageSize) {
        PageParames pageParames = PageParames.create(pageIndex, pageSize);
        Page<String> page = openUserQuery.list(pageParames);
        List<OperatorInfoDto> collect = page.getRows().stream().map(id -> getOperatorInfo(id)).collect(Collectors.toList());

        Page<OperatorInfoDto>  pageList = new Page<>();
        pageList.setPageIndex(pageIndex);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(page.getTotalCount());
        pageList.setRows(collect);
        return PageResult.build(pageList);
    }

    @Override
    public OperatorInfoDto login(LoginDto loginDto) {
        String peopleId = openUserQuery.getPeopleIdByPhone(loginDto.getPhone());
        if(StringUtils.isEmpty(peopleId)){
            throw new BusinessException("手机号不存在");
        }
        boolean flag = openUserQuery.existByAppIdAndPeopleId(loginDto.getAppId(),peopleId);
        if(!flag){//不存在则创建一个app用户
            OperatorAddDto userAddDto = new OperatorAddDto();
            userAddDto.setPhone(loginDto.getPhone());
            userAddDto.setAppId(loginDto.getAppId());
            addOperator(userAddDto);
        }

        if(loginDto.getSource() == LoginDto.Source.PASSWORD){
            String mark = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
            LoginInfoDmo loginInfoDmo = loginInfoQuery.getLoginInfoByPeopleIdAndSource(peopleId,loginDto.getSource().name());
            if(!StringUtils.equals(mark,loginInfoDmo.getMark())){
                throw new BusinessException("密码错误");
            }
            String openId = openUserQuery.getOpenIdByPeopleIdAndAppId(peopleId,loginDto.getAppId());
            return getOperatorInfo(openId);
        }

        if(loginDto.getSource() == LoginDto.Source.PHONE){
            String openId = openUserQuery.getOpenIdByPeopleIdAndAppId(peopleId,loginDto.getAppId());
            return getOperatorInfo(openId);
        }

        throw new BusinessException("不支持的登录方式:"+loginDto.getSource());
    }

    @Override
    public Boolean checkedPhone(String phone) {
        String peopleId = openUserQuery.getPeopleIdByPhone(phone);
        return !StringUtils.isEmpty(peopleId);
    }
}
