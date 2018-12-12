package com.cloud.webapi.context.auth;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class AuthHandlerInterceptor implements HandlerInterceptor {



    private List<String> anonymousPaths = new ArrayList<>();
    private PathMatcher pathMatcher = new AntPathMatcher();

    public void addAnonymousPaths(String... anonymousPaths) {
        this.anonymousPaths.addAll(Arrays.asList(anonymousPaths));
    }

    public boolean allowAnonymous(HttpServletRequest request) {

        if (anonymousPaths == null) return false;
        String url = request.getRequestURI().substring(request.getContextPath().length(), request.getRequestURI().length());

        return this.anonymousPaths.stream().anyMatch((path) -> {
            return this.pathMatcher.match(path, url);
        });
    }


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        String token = httpServletRequest.getHeader("Authorization");

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {

            if (!allowAnonymous(httpServletRequest)) {
                //不允许匿名访问时检查注解情况

//                HandlerMethod method = (HandlerMethod) handler;
//                Anonymous mno = ((HandlerMethod) handler).getMethodAnnotation(Anonymous.class);
//                Anonymous cno = method.getBean().getClass().getAnnotation(Anonymous.class);
//
//                if (mno != null) {
//                    //方法上有注解，以方法上的注解值为准
//                    if (!mno.value())
//                    {
//                        checkToken(token);
//                    }
//
//                } else if (cno != null) {
//                    //方法上没注解，以类上的注解值为准
//                    if (!cno.value()) {
//                        checkToken(token);
//                    }
//                } else {
//                    //其它情况全部验证
//                    checkToken(token);
//
//                }
            }
        }
        return true;
    }
//
//    private void checkToken(String token) {
//        if (StringUtils.isEmpty(token)) throw new NoLoginException("token为空");
//        TokenBuilder tokenBuilder = AuthManager.getTokenBuilder();
//        JWTUserDto user = tokenBuilder.getAuthUserByToken(token);
//        if (user == null) throw new NoLoginException("token无效" + token);
//    }
//
//    private void setUser(String token) {
//        TokenBuilder tokenBuilder = AuthManager.getTokenBuilder();
//        JWTUserDto user = tokenBuilder.getAuthUserByToken(token);
//        if(user!=null){
//            AuthManager.setUser(user);
//        }
//    }



    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
