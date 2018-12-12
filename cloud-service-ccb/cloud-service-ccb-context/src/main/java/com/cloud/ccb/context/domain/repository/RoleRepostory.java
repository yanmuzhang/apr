package com.cloud.ccb.context.domain.repository;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.core.EntityObjectUtils;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.IRepository;
import com.cloud.ccb.context.domain.mappers.PrivilegeDmoMapper;
import com.cloud.ccb.context.domain.mappers.RoleDmoMapper;
import com.cloud.ccb.context.domain.mappers.dmo.PrivilegeDmo;
import com.cloud.ccb.context.domain.mappers.dmo.PrivilegeDmoExample;
import com.cloud.ccb.context.domain.mappers.dmo.RoleDmo;
import com.cloud.ccb.context.domain.model.Privilege;
import com.cloud.ccb.context.domain.model.Role;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-20 15:46
 **/
@Component
public class RoleRepostory implements IRepository<Role,String> {

    @Autowired
    private RoleDmoMapper roleDmoMapper;

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    private PrivilegeDmoMapper privilegeDmoMapper;


    @Override
    public Role load(String id, EntityLoader entityLoader) {
        if(id == null){
            throw new BusinessException("id is null");
        }
        RoleDmo roleDmo = roleDmoMapper.selectByPrimaryKey(String.valueOf(id));
        if(roleDmo == null){
            return null;
        }
        Role role = entityLoader.create(Role.class);
        mapper.map(roleDmo,role);
        PrivilegeDmoExample example  = new PrivilegeDmoExample();
        example.createCriteria()
                .andMasterTypeEqualTo(Privilege.MasterType.ROLE.name())
                .andMasterIdEqualTo(role.getId())
                .andAccessTypeEqualTo(Privilege.AccessType.MENU.name());

        List<PrivilegeDmo> privilegeDmos = privilegeDmoMapper.selectByExample(example);
        if(privilegeDmos != null){
            Set<String> collect = privilegeDmos.stream().map(item -> item.getAccessId()).collect(Collectors.toSet());
            EntityObjectUtils.setValue(Role.class,role,"menus",collect);
        }
        return role;
    }

    @Override
    public void save(Role role) {
        if(role == null){
            throw new BusinessException("organization is null");
        }

        RoleDmo map = mapper.map(role, RoleDmo.class);
        if(roleDmoMapper.updateByPrimaryKey(map) == 0){
            roleDmoMapper.insert(map);
        }
    }

    @Override
    public void delete(Role role) {
        if(role == null){
            throw new BusinessException("id is null");
        }
        roleDmoMapper.deleteByPrimaryKey(role.getId());
    }
}
