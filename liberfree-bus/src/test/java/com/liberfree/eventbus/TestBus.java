package com.liberfree.eventbus;

import com.alibaba.fastjson.JSON;
import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.channel.def.DefaultChannelProvider;
import com.liberfree.eventbus.config.EventConfigItem;
import com.liberfree.eventbus.config.EventConfigManager;
import com.liberfree.eventbus.event.EventHandler;
import com.liberfree.eventbus.event.EventPublish;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * @author: zhangchao
 * @time: 2018-12-21 13:55
 **/
public class TestBus {






    public static void main(String[] args)  throws Exception{








        ChannelProvider channelProvider = new DefaultChannelProvider();
        channelProvider.init();
//
//        EventConfigItem a = new EventConfigItem();
//        a.setChannelProvider(channelProvider);
//        a.setEventName("A");
//        EventConfigManager.addEventSubcriberConfigItem(a);
//
//        EventConfigItem b = new EventConfigItem();
//        b.setChannelProvider(channelProvider);
//        b.setEventName("B");
//        EventConfigManager.addEventSubcriberConfigItem(b);


        EventBus.register(new EventHandler() {
            @Override
            public void handler(Object o) {
                System.out.println("收到A事件："+JSON.toJSONString(o));
            }

            @Override
            public String getEventName() {
                return "A";
            }
        });

        EventBus.register(new EventHandler() {
            @Override
            public void handler(Object o) {
                System.out.println("收到B事件："+JSON.toJSONString(o));
            }

            @Override
            public String getEventName() {
                return "B";
            }
        });

        String eventName = "";

        Scanner scanner  = new Scanner(System.in);
        while (!(eventName = scanner.next()).equals("exit")){
            String[] split = eventName.split(":");
            EventBus.publish(split[0],split[1]);
        }

    }


}