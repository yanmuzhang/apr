package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:06
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient 
@EnableZuulProxy
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
}

