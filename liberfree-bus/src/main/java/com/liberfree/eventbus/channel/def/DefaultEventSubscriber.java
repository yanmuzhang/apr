package com.liberfree.eventbus.channel.def;

import com.liberfree.eventbus.event.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhangchao
 * @time: 2018-12-21 15:22
 **/
public class DefaultEventSubscriber extends EventSubscriber {
    private final static Logger log = LoggerFactory.getLogger(DefaultEventSubscriber.class);

    DefaultEventSource defaultEventSource ;

    private boolean running = false;

    public DefaultEventSubscriber(DefaultEventSource defaultEventSource) {
        super();
        this.defaultEventSource = defaultEventSource;
    }

    @Override
    public void start() {
        defaultEventSource.addDefaultEventListenner(new DefaultEventListenner(this));
    }

    @Override
    public void stop() {
        this.running = false;
    }
}
