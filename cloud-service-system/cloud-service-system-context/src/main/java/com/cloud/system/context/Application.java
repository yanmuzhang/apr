package com.cloud.system.context;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: zhangchao
 * @time: 2018-08-21 10:32
 **/
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan({"com.cloud.system.context.repository.mappers","com.cloud.system.context.repository.query"})
@EnableEurekaClient
@EnableDiscoveryClient
//@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
}