package com.liberfree.eventbus;


import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.config.EventConfigItem;
import com.liberfree.eventbus.config.EventConfigManager;
import com.liberfree.eventbus.event.EventHandler;

/**
 * @author: zhangchao
 * @time: 2018-12-20 10:09
 **/
public  class EventBus {

    public static void publish(String eventName, Object object){
        EventConfigItem eventSubcriberConfigItem = EventConfigManager.get(eventName);
        ChannelProvider channelProvider = eventSubcriberConfigItem.getChannelProvider();
        channelProvider.sendMessage(eventName,object);
    }

    public static void register(EventHandler handler){
        EventConfigItem eventSubcriberConfigItem = EventConfigManager.get(handler.getEventName());
        ChannelProvider channelProvider = eventSubcriberConfigItem.getChannelProvider();
        channelProvider.subscriber(handler);
    }

}
