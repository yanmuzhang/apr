package com.cloud.webapi.web.v1;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.AppClient;
import com.cloud.ccb.api.OperatorClient;
import com.cloud.ccb.api.dto.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:52
 **/
@RestController
@RequestMapping("/app")
public class AppController {

    @Resource
    private AppClient appClient;
    /**
     * 添加用户
     * @param appDto
     */
    @PostMapping(value = "/add")
    public void addApp(@RequestBody AppDto appDto){
         appClient.addApp(appDto);
    };

    /**
     * 修改用户
     * @param appDto
     */
    @PostMapping(value = "/update")
    public void updateApp(@RequestBody AppDto appDto){
        appClient.updateApp(appDto);
    };


    /**
     * 用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/find")
    public AppDto find(@RequestParam("id") String id){
        return appClient.getApp(id);
    };

    /**
     * 用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/getPageList")
    public PageResult<AppDto> getPageList(
            @RequestParam(name = "orgId", required = false) String orgId,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        return appClient.getAppList(orgId,name,pageIndex,pageSize);
    };


}
