package com.cloud.system.context.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: zhangchao
 * @time: 2018-08-22 15:01
 **/
@Aspect
@Component
@Slf4j
public class RequestLoggingAspect {
    @Pointcut("execution(public * com.cloud.system.context.controller.*.*(..))")//要处理的方法，包名+类名+方法名
    public void cut() {
    }

    @Before("cut()")//在调用上面 @Pointcut标注的方法前执行以下方法
    public void doBefore(JoinPoint joinPoint) {//用于获取类方法
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //time
        log.info("time = {}", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        //url
        log.info("url ={}", request.getRequestURI());
        //method
        log.info("method={}", request.getMethod());
        //ip
        log.info("ip={}", request.getRemoteAddr());
        //类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + '.' + joinPoint.getSignature().getName());//获取类名及类方法
        //参数
        log.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "obj", pointcut = "cut()")//在调用上面 @Pointcut标注的方法后执行。用于获取返回值
    public void doAfterReturning(Object obj) {
        log.info("response={}", obj);
    }
}
