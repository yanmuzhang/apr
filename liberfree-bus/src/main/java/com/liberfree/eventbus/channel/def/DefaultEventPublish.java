package com.liberfree.eventbus.channel.def;

import com.alibaba.fastjson.JSON;
import com.liberfree.eventbus.event.EventPublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:27
 **/
public class DefaultEventPublish extends EventPublish {

    private final static Logger log = LoggerFactory.getLogger(DefaultEventPublish.class);
    DefaultEventSource defaultEventSource ;
    public DefaultEventPublish(DefaultEventSource defaultEventSource, DefaultChannelProvider defaultChannelProvider) {
        super(defaultChannelProvider);
        this.defaultEventSource = defaultEventSource;
    }

    @Override
    public void publishMessage() {
        log.debug("publishMessage:{}:{}",getEventName(), JSON.toJSONString(getMessageData()));
        defaultEventSource.send(getEventName(),getMessageData());
    }

}
