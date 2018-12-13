package com.cloud.ccb.api;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zhangchao
 * @time: 2018-11-15 11:30
 **/
@FeignClient(name = "cloud-service-ccb-context",configuration = FeignConfiguration.class)
public interface AppClient {

    /**
     * 添加用户
     * @param appDto
     */
    @PostMapping(value = "/app/addApp")
    void addApp(@RequestBody AppDto appDto);

    /**
     * 修改用户
     * @param appDto
     */
    @PostMapping(value = "/app/updateApp")
    void updateApp(@RequestBody AppDto appDto);


    /**
     * 用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/app/getApp")
    AppDto getApp(@RequestParam("id") String id);

    /**
     * 用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/app/getAppList")
    PageResult<AppDto> getAppList(
            @RequestParam(name = "orgId", required = false) String orgId,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize);






}
