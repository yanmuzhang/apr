package com.cloud.webapi.context.auth;

import com.cloud.webapi.context.jwt.AuthManager;
import com.cloud.webapi.context.jwt.JwtContextUtils;
import com.cloud.webapi.context.jwt.JwtUser;
import com.cloud.webapi.context.jwt.NoLoginException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtContextUtils jwtContextUtils;


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
                HandlerMethod method = (HandlerMethod) handler;
                Anonymous mno = method.getMethodAnnotation(Anonymous.class);
                if(mno == null){
                    mno = method.getBean().getClass().getAnnotation(Anonymous.class);
                }
                if (mno == null) {
                    checkToken(token);
                }
            }
        }
        setUser(token);
        return true;
    }

    private void checkToken(String token) {
        jwtContextUtils.verifyToken(token);
    }

    public void setUser(String token){
        JwtUser parse = jwtContextUtils.parse(token);
        if(parse !=  null){
            AuthManager.setUser(parse);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
