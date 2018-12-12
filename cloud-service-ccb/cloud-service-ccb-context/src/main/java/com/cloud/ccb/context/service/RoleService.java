package com.cloud.ccb.context.service;

import com.cloud.ccb.api.dto.RoleDto;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:23
 **/
public interface RoleService {

    void addRole(RoleDto roleDto);

    void editRole(RoleDto roleDto);

}
