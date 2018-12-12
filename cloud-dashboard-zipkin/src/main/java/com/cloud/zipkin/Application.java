package com.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:06
 **/
@SpringBootApplication
@EnableZipkinServer
public class Application {

    public static void main(String[] args) {
        System.out.println("http://localhost:10110/zipkin/");
        SpringApplication.run( Application.class, args );
    }
}

