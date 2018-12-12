package com.cloud.system.context.configuration;

/**
 * @author: zhangchao
 * @time: 2018-08-27 16:31
 **/

import com.cloud.common.pojo.PojoMapper;
import com.cloud.system.context.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

@Configuration
public class AppConfiguration  {


    @Bean
    public PojoMapper getPojoMapper(){
        PojoMapper pojoMapper = new PojoMapper();
        return pojoMapper;
    }


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> beansOfType = SpringUtils.getBeansOfType(AdminService.class);
        beansOfType.entrySet().forEach(map -> System.out.println(map.getKey()));
    }
}
