package com.cloud.webapi.context.configration;

import com.cloud.webapi.web.v1.config.Version;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class VersionConfiguration {

    @Bean
    public ServletRegistrationBean servletRegistrationBeanV1() {
        AnnotationConfigWebApplicationContext applicationContext  = new AnnotationConfigWebApplicationContext();
        //base package
        applicationContext.scan(Version.SCAN_PACKAGE);
        //通过构造函数指定dispatcherServlet的上下文
        DispatcherServlet rest_dispatcherServlet = new DispatcherServlet(applicationContext);

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean  = new ServletRegistrationBean(rest_dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定urlmapping
        registrationBean.addUrlMappings(Version.URL_MAPPING);
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName(Version.ID);
        return registrationBean;
    }
}
