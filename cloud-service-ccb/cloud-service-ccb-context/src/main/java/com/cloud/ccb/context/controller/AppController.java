package com.cloud.ccb.context.controller;

import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-11-13 12:29
 **/
@RestController
@RequestMapping("/app")
public class AppController {



    @Autowired
    private AppService appService;

    @GetMapping
    public List<App> list(){
        return appService.list(null);
    }

//    @PostMapping
//    public void add(String name,String orgId){
//        appService.save(orgId,name);
//    }




}
