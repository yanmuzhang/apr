package com.liberfree.eventbus;


import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.config.EventConfigItem;
import com.liberfree.eventbus.config.EventConfigManager;
import com.liberfree.eventbus.event.EventHandler;

/**
 * @author: zhangchao
 * @time: 2018-12-20 10:09
 **/
public class EventBus {

    public static void publish(String eventName, Object object){
        EventConfigItem eventConfigItem = EventConfigManager.get(eventName);
        ChannelProvider channelProvider = eventConfigItem.getChannelProvider();
        channelProvider.sendMessage(eventName,object);
    }

    public static void register(EventHandler handler){
        EventConfigItem eventConfigItem = EventConfigManager.get(handler.getEventName());
        ChannelProvider channelProvider = eventConfigItem.getChannelProvider();
        channelProvider.subscriber(handler);
    }

}
