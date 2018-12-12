package com.cloud.webapi.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:06
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan({"com.cloud"})
@EnableFeignClients(basePackages ={ "com.cloud.*.api","com.cloud.ccb.api"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
}

