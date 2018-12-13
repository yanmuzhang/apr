package com.cloud.ccb.context.controller;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.AppClient;
import com.cloud.ccb.api.dto.AppDto;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-11-13 12:29
 **/
@RestController
public class AppController implements AppClient {



    @Autowired
    private AppService appService;


    @Override
    public void addApp(@RequestBody AppDto appDto) {
        appService.addApp(appDto);
    }

    @Override
    public void updateApp(@RequestBody AppDto appDto) {
        appService.updateApp(appDto);
    }

    @Override
    public AppDto getApp(@RequestParam("id") String id) {
        return  appService.getApp(id);
    }

    @Override
    public PageResult<AppDto> getAppList( @RequestParam(name = "orgId", required = false) String orgId,
                                          @RequestParam(name = "name", required = false) String name,
                                          @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
                                          @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return  appService.getAppList(orgId,name,pageIndex,pageSize);
    }
//
//    @GetMapping
//    public List<App> list(){
//        return appService.list(null);
//    }

//    @PostMapping
//    public void add(String name,String orgId){
//        appService.save(orgId,name);
//    }




}
