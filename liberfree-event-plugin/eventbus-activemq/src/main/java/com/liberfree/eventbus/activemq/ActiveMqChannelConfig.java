package com.liberfree.eventbus.activemq;

import com.liberfree.eventbus.channel.ChannelConfig;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-12-25 15:01
 **/
public class ActiveMqChannelConfig extends ChannelConfig {

    private String url;
    private String username;
    private String password;



    public ActiveMqChannelConfig(Properties properties) {
        super(properties);
        this.url = properties.getProperty("url");
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
    }


    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
