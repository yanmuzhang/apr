package com.cloud.system.context.service;

import com.cloud.common.Page;
import com.cloud.common.PageResult;
import com.cloud.system.api.dto.AdminDto;

/**
 * @author: zhangchao
 * @time: 2018-08-21 14:52
 **/
public interface AdminService {

    String login(String username, String password);

    AdminDto getAdmin(String id);

    PageResult<AdminDto> list(Page<AdminDto> page);

    String save(AdminDto adminDto);

    void update(AdminDto adminDto);

    void delele(String id);
}
