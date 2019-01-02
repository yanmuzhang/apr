package com.liberfree.eventbus.channel.def;

import com.alibaba.fastjson.JSON;
import com.liberfree.eventbus.event.EventHandlerData;
import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EventListener;

/**
 * @author: zhangchao
 * @time: 2018-12-21 15:59
 **/
public class DefaultEventListenner implements EventListener {
    private final static Logger log = LoggerFactory.getLogger(DefaultEventSubscriber.class);
    private EventSubscriber eventSubscriber;




    public DefaultEventListenner(EventSubscriber eventSubscriber) {
        this.eventSubscriber = eventSubscriber;
    }


    public void onEvent(String eventName,MessageData obj){
        if(eventName.equals(eventSubscriber.getEventHandler().getEventName())){
            try {
                eventSubscriber.getEventHandler().handler((EventHandlerData)obj.getData());
            } catch (Exception e) {
                log.error("事件[{}]消费失败:{}",eventName, JSON.toJSONString(obj));
            }
        }
    }


}
