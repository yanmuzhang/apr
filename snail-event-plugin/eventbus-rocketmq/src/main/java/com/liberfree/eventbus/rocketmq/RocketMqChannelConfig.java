package com.liberfree.eventbus.rocketmq;

import com.liberfree.eventbus.channel.ChannelConfig;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-12-26 15:41
 **/
public class RocketMqChannelConfig extends ChannelConfig {

    private String hosts;


    public RocketMqChannelConfig(Properties properties) {
        super(properties);
        this.hosts = properties.getProperty("host");
    }


    public String getHost() {
        return hosts;
    }

}
