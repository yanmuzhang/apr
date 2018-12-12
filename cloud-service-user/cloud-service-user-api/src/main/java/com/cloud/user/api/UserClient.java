package com.cloud.user.api;

import com.cloud.common.Page;
import com.cloud.user.api.dto.LoginDto;
import com.cloud.user.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("cloud-service-user-context")
public interface UserClient {

    @PostMapping(value = "/login")
    String login(@RequestBody LoginDto loginDto);

    @GetMapping(value = "/user/{id}")
    UserDto getUser(@PathVariable("id") String id);

    @PostMapping(value = "/user")
    void save(@RequestBody UserDto user);

    @GetMapping(value = "/user")
    Page<UserDto> list(Page<UserDto> page);



}
