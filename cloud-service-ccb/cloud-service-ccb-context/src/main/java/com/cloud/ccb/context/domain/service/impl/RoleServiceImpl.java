package com.cloud.ccb.context.domain.service.impl;

import cn.liberfree.de.loader.EntityLoader;
import com.cloud.ccb.api.dto.RoleDto;
import com.cloud.ccb.context.domain.model.Role;
import com.cloud.ccb.context.domain.service.RoleService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:23
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private EntityLoader entityLoader;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public void addRole(RoleDto roleDto) {
        Role role = entityLoader.create(Role.class);
        role.init(roleDto.getName(),roleDto.getDescription(),roleDto.getMenus());
    }

    @Override
    public void editRole(RoleDto roleDto) {
        Role role = entityLoader.load(roleDto.getId(),Role.class);
        role.edit(roleDto.getName(),roleDto.getDescription(),roleDto.getMenus());
    }
}
