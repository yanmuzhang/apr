package com.cloud.webapi.web.v1;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.RoleClient;
import com.cloud.ccb.api.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-12-17 15:46
 **/
@RestController
public class RoleController {



    @Autowired
    private RoleClient roleClient;


    @GetMapping("/role")
    public PageResult<RoleDto> getPageList(@RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
                                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        return roleClient.getPageList(name,pageIndex,pageSize);
    }

    @GetMapping("/role/{id}")
    public RoleDto getRole(@PathVariable("id") String id){
        return roleClient.getRole(id);
    }

    @PostMapping("/role")
    public void addRole(@RequestBody RoleDto menuDto){
        roleClient.addRole(menuDto);
    }

    @PutMapping("/role")
    public void editRole(@RequestBody RoleDto menuDto){
        roleClient.editRole(menuDto);
    }

    @DeleteMapping("/role")
    public void delete(@RequestParam("id") String id){
        roleClient.delete(id);
    }
}
