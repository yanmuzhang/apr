package com.liberfree.eventbus.rocketmq;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;

/**
 * @author: zhangchao
 * @time: 2018-12-26 15:41
 **/
public class RocketMqChannelProvider extends ChannelProvider<RocketMqChannelConfig> {

    public RocketMqChannelProvider(RocketMqChannelConfig channelConfig) {
        super(channelConfig);
    }

    @Override
    public void init() {

    }

    @Override
    public EventSubscriber createEventSubscriber() {
        return new RocketMqEventSubscriber(this);
    }

    @Override
    public EventPublish createEventPublish() {
        if(rocketMqEventPublish == null){
            rocketMqEventPublish = new RocketMqEventPublish(this);
        }
        return rocketMqEventPublish;
    }

    private RocketMqEventPublish rocketMqEventPublish;
}
