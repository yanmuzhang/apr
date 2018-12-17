package com.cloud.ccb.context.controller;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.RoleClient;
import com.cloud.ccb.api.dto.RoleDto;
import com.cloud.ccb.context.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-12-17 15:18
 **/
@RestController
public class RoleController extends BaseController implements RoleClient {


    @Autowired
    private RoleService roleService;

    public RoleDto getRole(@PathVariable("id") String id){
        return roleService.getRole(id);
    }

    public void addRole(@RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
    }

    public void editRole(@RequestBody RoleDto roleDto){
        roleService.editRole(roleDto);
    }

    public PageResult<RoleDto> getPageList(@RequestParam(value = "name",required = false,defaultValue = "") String name,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        return  roleService.getPageList(name,pageIndex,pageSize);
    }

    public void delete(@PathVariable("id") String id){
        roleService.delete(id);
    }
}
