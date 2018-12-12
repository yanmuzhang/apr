package com.cloud.ccb.context.configuration;

/**
 * @author: zhangchao
 * @time: 2018-08-27 16:31
 **/

import cn.liberfree.de.loader.EntityLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public EntityLoader entityLoader(){
        return new EntityLoader();
    }

}
