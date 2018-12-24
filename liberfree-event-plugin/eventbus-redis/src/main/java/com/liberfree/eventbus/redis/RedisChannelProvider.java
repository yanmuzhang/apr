package com.liberfree.eventbus.redis;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;

/**
 * @author: zhangchao
 * @time: 2018-12-24 17:28
 **/
public class RedisChannelProvider extends ChannelProvider {




    public void init() {

    }

    public EventSubscriber createEventSubscriber() {
        return null;
    }

    public EventPublish createEventPublish() {
        return null;
    }
}
