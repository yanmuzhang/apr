package com.liberfree.eventbus.config;

import com.liberfree.eventbus.channel.ChannelProvider;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:05
 **/
public class EventConfigItem {

    private ChannelProvider channelProvider;
    private String eventName;

    public ChannelProvider getChannelProvider() {
        return channelProvider;
    }

    public void setChannelProvider(ChannelProvider channelProvider) {
        this.channelProvider = channelProvider;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
