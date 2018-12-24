package com.liberfree.eventbus.channel.def;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:26
 **/
public class DefaultChannelProvider extends ChannelProvider {
    private final static Logger log = LoggerFactory.getLogger(DefaultChannelProvider.class);

    DefaultEventSource defaultEventSource = new DefaultEventSource();

    @Override
    public void init() {
            log.debug("init DefaultChannelProvider");
    }


    @Override
    public EventSubscriber createEventSubscriber() {
        return new DefaultEventSubscriber(defaultEventSource);
    }

    @Override
    public DefaultEventPublish createEventPublish() {
        return new DefaultEventPublish(defaultEventSource,this);
    }
}
