package com.cloud.ccb.context.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhangchao
 * @time: 2018-12-11 16:33
 **/
public class BaseController {

    static final String APPID  = "X-appId";

    @Autowired
    HttpServletRequest httpServletRequest;


    public String getAppId(){
        return httpServletRequest.getHeader(APPID);
    }

}
