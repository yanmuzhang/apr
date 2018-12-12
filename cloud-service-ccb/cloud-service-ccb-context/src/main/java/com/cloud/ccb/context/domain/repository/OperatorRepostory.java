package com.cloud.ccb.context.domain.repository;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.core.EntityObjectUtils;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.IRepository;
import com.cloud.ccb.context.domain.mappers.OperatorAttrDmoMapper;
import com.cloud.ccb.context.domain.mappers.OperatorDmoMapper;
import com.cloud.ccb.context.domain.mappers.OperatorRoleDmoMapper;
import com.cloud.ccb.context.domain.mappers.dmo.*;
import com.cloud.ccb.context.domain.model.OperatorAttr;
import com.cloud.ccb.context.domain.model.Operator;
import com.cloud.ccb.context.domain.query.AttrQuery;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-15 10:18
 **/
@Component
public class OperatorRepostory implements IRepository<Operator,String> {

    @Autowired
    private OperatorDmoMapper openUserDmoMapper;

    @Autowired
    private AttrQuery attrQuery;

    @Autowired
    private OperatorAttrDmoMapper attrDmoMapper;

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    OperatorRoleDmoMapper  operatorRoleDmoMapper;


    @Override
    public Operator load(String id, EntityLoader entityLoader) {
        if(ObjectUtils.isEmpty(id)){
            throw new BusinessException("id 不能为空");
        }
        OperatorDmo openUserDmo = openUserDmoMapper.selectByPrimaryKey(id);

        Operator operator = entityLoader.create(openUserDmo.getId(),Operator.class);
        mapper.map(openUserDmo,operator);

        OperatorAttrDmoExample openUserAttrDmoExample = new OperatorAttrDmoExample();
        openUserAttrDmoExample.createCriteria().andOperatorIdEqualTo(operator.getId());

        Set<OperatorAttr> appAttrs = attrQuery.getAppAttrByAppId(openUserDmo.getAppId());

        Set<OperatorAttr> userAttrs = attrQuery.getUserAttrByOperatorId(operator.getId());

        for (OperatorAttr appAttr : appAttrs) {
            for (OperatorAttr userAttr : userAttrs) {
                if(StringUtils.equals(appAttr.getName(),userAttr.getName())){
                    appAttr.setValue(userAttr.getValue());
                    break;
                }
            }
        }
        EntityObjectUtils.setValue(Operator.class,operator,"attrSet",appAttrs);

        OperatorRoleDmoExample operatorRoleDmoExample = new OperatorRoleDmoExample();
        OperatorRoleDmoExample.Criteria criteria = operatorRoleDmoExample.createCriteria();
        criteria.andOperatorIdEqualTo(operator.getId());
        List<OperatorRoleDmo> operatorRoleDmos = operatorRoleDmoMapper.selectByExample(operatorRoleDmoExample);
        if(operatorRoleDmos != null){
            Set<String> roles = operatorRoleDmos.stream().map(item -> item.getRoleId()).collect(Collectors.toSet());
            EntityObjectUtils.setValue(Operator.class,operator,"roles",roles);
        }

        return operator;
    }

    @Override
    public void save(Operator operator) {
        if(ObjectUtils.isEmpty(operator)){
            throw new BusinessException("openUser 不能为空");
        }

        OperatorDmo openUserDmo = mapper.map(operator, OperatorDmo.class);

        if(openUserDmoMapper.updateByPrimaryKey(openUserDmo) == 0){
            openUserDmoMapper.insert(openUserDmo);
        }

        attrQuery.deleteUserAttrByOperatorId(operator.getId());

        Set<OperatorAttr> appAttrs = attrQuery.getAppAttrByAppId(operator.getAppId());

        if(operator.getAttrSet() != null){
            for (OperatorAttr appAttr : appAttrs) {
                for (OperatorAttr userAttr : operator.getAttrSet()) {
                    if(StringUtils.equals(appAttr.getName(),userAttr.getName())){
                        appAttr.setValue(userAttr.getValue());
                        break;
                    }
                }
            }
        }
        appAttrs.stream().map(item ->{
            OperatorAttrDmo map = mapper.map(item, OperatorAttrDmo.class);
            map.setOperatorId(operator.getId());
            return map;
        }).forEach(item->attrDmoMapper.insert(item));


        OperatorRoleDmoExample operatorRoleDmoExample = new OperatorRoleDmoExample();
        OperatorRoleDmoExample.Criteria criteria = operatorRoleDmoExample.createCriteria();
        criteria.andOperatorIdEqualTo(operator.getId());
        operatorRoleDmoMapper.deleteByExample(operatorRoleDmoExample);
        Set<String> roles = operator.getRoles();
        if(roles != null){
            roles.stream().forEach(id ->{
                OperatorRoleDmo operatorRoleDmo = new OperatorRoleDmo();
                operatorRoleDmo.setOperatorId(operator.getId());
                operatorRoleDmo.setRoleId(id);
                operatorRoleDmoMapper.insert(operatorRoleDmo);
            });
        }
    }

    @Override
    public void delete(Operator operator) {
        if(ObjectUtils.isEmpty(operator)){
            throw new BusinessException("openUser 不能为空");
        }

        attrQuery.deleteUserAttrByOperatorId(operator.getId());
        openUserDmoMapper.deleteByPrimaryKey(operator.getId());

        OperatorRoleDmoExample operatorRoleDmoExample = new OperatorRoleDmoExample();
        OperatorRoleDmoExample.Criteria criteria = operatorRoleDmoExample.createCriteria();
        criteria.andOperatorIdEqualTo(operator.getId());
        operatorRoleDmoMapper.deleteByExample(operatorRoleDmoExample);
    }
}
