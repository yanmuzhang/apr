package com.cloud.user.context;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author: zhangchao
 * @time: 2018-07-27 15:50
 **/
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.cloud.user.context.repository.mappers")
@EnableEurekaClient
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
}
