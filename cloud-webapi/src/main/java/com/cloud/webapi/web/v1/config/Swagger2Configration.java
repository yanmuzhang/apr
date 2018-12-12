package com.cloud.webapi.web.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class Swagger2Configration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Arrays.asList(new ApiKey("Authorization", "Authorization", "header")))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(Version.SCAN_PACKAGE))
                //.apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户中心 App RESTful APIs")
                .description("用户中心 App 接口-IOT")
                .version(Version.ID)
                .build();
    }

}
