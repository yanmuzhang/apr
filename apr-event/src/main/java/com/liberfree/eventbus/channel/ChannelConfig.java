package com.liberfree.eventbus.channel;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-12-25 14:59
 **/
public abstract class ChannelConfig {
    private Properties properties;

    public ChannelConfig(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
