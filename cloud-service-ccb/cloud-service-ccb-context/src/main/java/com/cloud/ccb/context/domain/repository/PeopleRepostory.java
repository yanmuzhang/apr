package com.cloud.ccb.context.domain.repository;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.core.EntityObjectUtils;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.IRepository;
import com.cloud.ccb.context.domain.mappers.BindingPhoneHistoryDmoMapper;
import com.cloud.ccb.context.domain.mappers.CertificationInfoDmoMapper;
import com.cloud.ccb.context.domain.mappers.LoginInfoDmoMapper;
import com.cloud.ccb.context.domain.mappers.PeopleDmoMapper;
import com.cloud.ccb.context.domain.mappers.dmo.*;
import com.cloud.ccb.context.domain.model.BindingPhoneHistory;
import com.cloud.ccb.context.domain.model.CertificationInfo;
import com.cloud.ccb.context.domain.model.LoginInfo;
import com.cloud.ccb.context.domain.model.People;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-15 10:36
 **/
@Component
public class PeopleRepostory implements IRepository<People,String> {

    @Autowired
    private PeopleDmoMapper peopleDmoMapper;

    @Autowired
    private CertificationInfoDmoMapper certificationInfoDmoMapper;

    @Autowired
    private BindingPhoneHistoryDmoMapper bindingPhoneHistoryDmoMapper;

    @Autowired
    private LoginInfoDmoMapper loginInfoDmoMapper;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public People load(String id, EntityLoader entityLoader) {
        if(id == null){
            throw new BusinessException("id is null");
        }
        PeopleDmo peopleDmo = peopleDmoMapper.selectByPrimaryKey(id);
        People people = entityLoader.create(peopleDmo.getId(),People.class);

        CertificationInfoDmoExample certificationInfoDmoExample = new CertificationInfoDmoExample();
        certificationInfoDmoExample.createCriteria().andPeopleIdEqualTo(people.getId());
        List<CertificationInfoDmo> certificationInfoDmos = certificationInfoDmoMapper.selectByExample(certificationInfoDmoExample);

        CertificationInfo certificationInfo = null;
        if(certificationInfoDmos.size() > 0){
            certificationInfo = new CertificationInfo();
            CertificationInfoDmo certificationInfoDmo = certificationInfoDmos.get(0);
            certificationInfo.init(certificationInfoDmo.getIdCardNumber(),
                    certificationInfoDmo.getName(),certificationInfoDmo.getCardFront(),certificationInfoDmo.getCardBack());
        }

        BindingPhoneHistoryDmoExample bindingPhoneHistoryDmoExample = new BindingPhoneHistoryDmoExample();
        bindingPhoneHistoryDmoExample.createCriteria().andPeopleIdEqualTo(people.getId());
        List<BindingPhoneHistoryDmo> bindingPhoneHistoryDmos = bindingPhoneHistoryDmoMapper.selectByExample(bindingPhoneHistoryDmoExample);

        List<BindingPhoneHistory> collect = bindingPhoneHistoryDmos.stream().map(i -> mapper.map(i, BindingPhoneHistory.class)).collect(Collectors.toList());

        EntityObjectUtils.setValue(People.class,people,"phone",peopleDmo.getPhone());
        EntityObjectUtils.setValue(People.class,people,"certificationInfo",certificationInfo);
        EntityObjectUtils.setValue(People.class,people,"phoneHistoryList",collect);
        return people;
    }

    @Override
    public void save(People people) {
        if(people == null){
            throw new BusinessException("people is null");
        }

        PeopleDmo peopleDmo = mapper.map(people, PeopleDmo.class);
        if(peopleDmoMapper.updateByPrimaryKey(peopleDmo) == 0){
            peopleDmoMapper.insert(peopleDmo);
        }

        CertificationInfo certificationInfo = people.getCertificationInfo();

        CertificationInfoDmoExample certificationInfoDmoExample = new CertificationInfoDmoExample();
        certificationInfoDmoExample.createCriteria().andPeopleIdEqualTo(people.getId());
        certificationInfoDmoMapper.deleteByExample(certificationInfoDmoExample);
        if(certificationInfo != null){
            CertificationInfoDmo map = mapper.map(certificationInfo, CertificationInfoDmo.class);
            certificationInfoDmoMapper.insert(map);
        }


        List<BindingPhoneHistory> phoneHistoryList = people.getPhoneHistoryList();
        BindingPhoneHistoryDmoExample bindingPhoneHistoryDmoExample = new BindingPhoneHistoryDmoExample();
        bindingPhoneHistoryDmoExample.createCriteria().andPeopleIdEqualTo(people.getId());
        bindingPhoneHistoryDmoMapper.deleteByExample(bindingPhoneHistoryDmoExample);

        if(phoneHistoryList!= null){
            phoneHistoryList.forEach(item ->{
                BindingPhoneHistoryDmo bindingPhoneHistoryDmo = mapper.map(item, BindingPhoneHistoryDmo.class);
                bindingPhoneHistoryDmoMapper.insert(bindingPhoneHistoryDmo);
            });
        }

        Set<LoginInfo> loginInfos = people.getLoginInfos();

        loginInfoDmoMapper.deleteByPrimaryKey(people.getId());
        if(loginInfos != null){
            for (LoginInfo loginInfo : loginInfos) {
                LoginInfoDmo loginInfoDmo = mapper.map(loginInfo, LoginInfoDmo.class);
                loginInfoDmo.setPeopleId(people.getId());
                loginInfoDmoMapper.insert(loginInfoDmo);
            }
        }

    }

    @Override
    public void delete(People people) {
        if(people == null){
            throw new BusinessException("people is null");
        }
        peopleDmoMapper.deleteByPrimaryKey(people.getId());

        BindingPhoneHistoryDmoExample bindingPhoneHistoryDmoExample = new BindingPhoneHistoryDmoExample();
        bindingPhoneHistoryDmoExample.createCriteria().andPeopleIdEqualTo(people.getId());
        bindingPhoneHistoryDmoMapper.deleteByExample(bindingPhoneHistoryDmoExample);

        CertificationInfoDmoExample certificationInfoDmoExample = new CertificationInfoDmoExample();
        certificationInfoDmoExample.createCriteria().andPeopleIdEqualTo(people.getId());
        certificationInfoDmoMapper.deleteByExample(certificationInfoDmoExample);
    }
}
