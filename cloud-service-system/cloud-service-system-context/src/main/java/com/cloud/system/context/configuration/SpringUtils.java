package com.cloud.system.context.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-09-05 11:26
 **/
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils .applicationContext = applicationContext;
    }

    public static <T> T getBean(String name){
        return (T) SpringUtils.applicationContext.getBean(name);
    }

    public static <T> T getBean(Class name){
        return (T) SpringUtils.applicationContext.getBean(name);
    }

    public static String[] getBeanNamesForType(Class c){
        return SpringUtils.applicationContext.getBeanNamesForType(c);
    }

    public static Map<String,Object> getBeansOfType(Class c){
        return SpringUtils.applicationContext.getBeansOfType(c);
    }
}
