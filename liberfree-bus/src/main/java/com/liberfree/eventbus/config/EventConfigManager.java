package com.liberfree.eventbus.config;

import com.liberfree.eventbus.channel.def.DefaultChannelProvider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:06
 **/
public class EventConfigManager {

    private static Map<String,EventConfigItem> subscriberItemConcurrentHashMap = new ConcurrentHashMap<String,EventConfigItem>();

    private static String DEFAULT_CHANNEL = "DEFAULT_CHANNEL";


    static {

        //创建默认通道 内存通道
        EventConfigItem eventSubcriberConfigItem = new EventConfigItem();
        eventSubcriberConfigItem.setEventName(DEFAULT_CHANNEL);
        eventSubcriberConfigItem.setChannelProvider(new DefaultChannelProvider());
        addEventSubcriberConfigItem(eventSubcriberConfigItem);


        //加载其他通道

        //加载订阅配置
    }


    public static void addEventSubcriberConfigItem(EventConfigItem eventSubcriberConfigItem){
        subscriberItemConcurrentHashMap.put(eventSubcriberConfigItem.getEventName(),eventSubcriberConfigItem);
    }

    public static EventConfigItem get(String eventName){
        EventConfigItem eventSubcriberConfigItem = subscriberItemConcurrentHashMap.get(eventName);
        if(eventSubcriberConfigItem == null){
            eventSubcriberConfigItem = subscriberItemConcurrentHashMap.get(DEFAULT_CHANNEL);
        }
        return eventSubcriberConfigItem;
    }

}
