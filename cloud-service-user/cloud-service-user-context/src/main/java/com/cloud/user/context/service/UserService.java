package com.cloud.user.context.service;

import com.cloud.common.Page;
import com.cloud.user.api.dto.UserDto;

public interface UserService {

//    public User load(String id);


    String login(String username, String password);


    void save(UserDto user);

    Page<UserDto> list(Page<UserDto> page);
}
