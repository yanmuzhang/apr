package com.cloud.webapi.context.configration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-08-16 14:35
 **/
@Getter
@Setter
@Component
@ConfigurationProperties(prefix="spring")
public final class CloudConfigProperties {

    private final Jwt jwt = new Jwt();

    @Setter
    @Getter
    public final static class Jwt{
        @Value("${secret}")
        private  String secret;
        @Value("${expiration}")
        private  Long expiration;
    }
}
