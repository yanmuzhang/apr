package com.cloud.webapi.context.jwt;

/**
 * @author: zhangchao
 * @time: 2018-12-18 11:17
 **/
public class AuthManager {
    private static ThreadLocal<JwtUser> threadLocal = new ThreadLocal<>();


    public static void setUser(JwtUser jwtUser){
        threadLocal.set(jwtUser);
    }

    public static JwtUser currentUser(){
        return threadLocal.get();
    }

}
