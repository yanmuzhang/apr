package com.liberfree.eventbus.event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.message.MessageData;

/**
 * @author: zhangchao
 * @time: 2018-12-21 15:14
 **/
public abstract class EventPublish {

    private String  eventName;

    private MessageData messageData;

    private ChannelProvider channelProvider;

    public EventPublish(ChannelProvider channelProvider) {
        this.channelProvider = channelProvider;
    }

    public MessageData getMessageData() {
        return messageData;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setMessageData(MessageData messageData) {
        this.messageData = messageData;
    }

    public ChannelProvider getChannelProvider() {
        return channelProvider;
    }

    public abstract void publishMessage();

}
