package com.liberfree.eventbus.channel;

import com.liberfree.eventbus.event.EventHandler;
import com.liberfree.eventbus.event.EventHandlerData;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;

import java.util.HashSet;
import java.util.Set;

/**
 * 通道提供者
 * @author: zhangchao
 * @time: 2018-12-21 10:57
 **/
public abstract class ChannelProvider<T extends ChannelConfig> {


    private T channelConfig;

    public ChannelProvider(T channelConfig) {
        this.channelConfig = channelConfig;
    }

    public Set<EventSubscriber> subscriberSet = new HashSet<>();


    public void sendMessage(String eventName,Object data){
        EventPublish eventPublish = createEventPublish();
        eventPublish.setMessageData(MessageData.createMessageData(data));
        eventPublish.setEventName(eventName);
        eventPublish.publishMessage();
    }


    public void subscriber(EventHandler eventHandler){
        EventSubscriber eventSubscriber = createEventSubscriber();
        eventSubscriber.setEventHandler(eventHandler);
        eventSubscriber.start();
        subscriberSet.add(eventSubscriber);
    }

    public void stop(){
        subscriberSet.stream().forEach(item -> item.stop());
    }

    public abstract void init();

    public abstract EventSubscriber createEventSubscriber();

    public abstract EventPublish createEventPublish();


    public T getChannelConfig() {
        return channelConfig;
    }

    public void setChannelConfig(T channelConfig) {
        this.channelConfig = channelConfig;
    }
}