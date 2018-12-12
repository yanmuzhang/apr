package com.cloud.user.context.controller;

import com.cloud.common.Page;
import com.cloud.user.api.UserClient;
import com.cloud.user.api.dto.LoginDto;
import com.cloud.user.api.dto.UserDto;
import com.cloud.user.context.configuration.CloudConfigProperties;
import com.cloud.user.context.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:25
 **/
@RestController
public class UserController implements UserClient {


    @Autowired
    private UserService userService;

    @Autowired
    private CloudConfigProperties properties;

    @Override
    public String login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto.getUsername(),loginDto.getPassword());
    }

    @Override
    public UserDto getUser(@PathVariable("id") String id) {
        return new UserDto();
    }

    @Override
    public Page<UserDto> list(Page<UserDto> page) {
        return  userService.list(page);
    }

    @Override
    public void save(@RequestBody UserDto user) {
        userService.save(user);
    }
}
