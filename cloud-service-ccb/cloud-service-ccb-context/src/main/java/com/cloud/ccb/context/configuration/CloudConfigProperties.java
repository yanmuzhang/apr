package com.cloud.ccb.context.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-08-16 14:35
 **/
@Getter
@Setter
@Component
@ConfigurationProperties(prefix="app")
public final class CloudConfigProperties {
    private String name;
    private String language;
}
