package com.cloud.system.context.controller;

import com.cloud.common.Page;
import com.cloud.common.PageResult;
import com.cloud.system.api.SystemClient;
import com.cloud.system.api.dto.AdminDto;
import com.cloud.system.api.dto.LoginDto;
import com.cloud.system.context.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangchao
 * @time: 2018-08-21 15:02
 **/
@RestController
public class SystemController implements SystemClient {


    @Autowired
    AdminService adminService;

    @Override
    public String login(@RequestBody LoginDto loginDto) {
        return adminService.login(loginDto.getUsername(),loginDto.getPassword());
    }

    @Override
    public AdminDto getAdmin(@PathVariable("id") String id) {
        return adminService.getAdmin(id);
    }

    @Override
    public PageResult<AdminDto> list(Page<AdminDto> page) {
        return  adminService.list(page);
    }

    @Override
    public String saveAdmin(@RequestBody AdminDto adminDto) {
        String id = adminService.save(adminDto);
        return id;
    }

    @Override
    public void updateAdmin(@RequestBody AdminDto adminDto) {
         adminService.save(adminDto);
    }

    @Override
    public void deleteAdmin(@PathVariable("id") String id) {
        adminService.delele(id);
    }
}
