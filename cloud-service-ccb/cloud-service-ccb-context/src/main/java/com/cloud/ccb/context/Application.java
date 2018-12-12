package com.cloud.ccb.context;

import cn.liberfree.de.spring.EnableDe;
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
@MapperScan({"com.cloud.ccb.context.domain.mappers","com.cloud.ccb.context.domain.query"})
@EnableEurekaClient
@EnableDe
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
}
