package com.cloud.ccb.context.service;

import com.cloud.ccb.api.dto.RoleDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RoleServiceTest extends BaseServiceTest{


    @Autowired
    RoleService roleService;


    @Test
    public void addRole() {
        RoleDto roleDto = new RoleDto();
        roleDto.setName("超级管理员");
        roleDto.setDescription("最顶级的管理员");
        roleService.addRole(roleDto);
    }

    @Test
    public void editRole() {


    }
}