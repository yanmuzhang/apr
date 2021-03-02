package com.liberfree.eventbus.redis;

import com.liberfree.eventbus.channel.ChannelConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-12-25 15:01
 **/
public class RedisChannelConfig extends ChannelConfig {

    private List<String> host;
    private String auth;
    private Integer maxIdle;
    private Integer maxTotal;
    private String masterName;


    public RedisChannelConfig(Properties properties) {
        super(properties);
        String host = properties.getProperty("host");
        this.host = Arrays.asList(host.split(","));
        this.auth = properties.getProperty("auth");
        this.maxIdle = Integer.valueOf(properties.getProperty("maxIdle","5"));
        this.maxTotal = Integer.valueOf(properties.getProperty("maxTotal","10"));
        this.masterName = properties.getProperty("masterName");
    }

    public List<String> getHosts() {
        return host;
    }

    public String getAuth() {
        return auth;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public String getMasterName() {
        return masterName;
    }
}
