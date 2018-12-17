package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.RoleDto;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:23
 **/
public interface RoleService {

    RoleDto getRole(String id);

    void addRole(RoleDto roleDto);

    void editRole(RoleDto roleDto);

    PageResult<RoleDto> getPageList(String name,Integer pageIndex,Integer pageSize);

    void delete(String id);
}
