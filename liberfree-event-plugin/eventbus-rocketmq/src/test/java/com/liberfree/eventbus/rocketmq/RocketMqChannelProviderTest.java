package com.liberfree.eventbus.rocketmq;

import com.liberfree.eventbus.EventBus;
import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.config.EventConfigItem;
import com.liberfree.eventbus.config.EventConfigManager;
import com.liberfree.eventbus.event.EventHandler;

import java.util.Properties;
import java.util.Scanner;

public class RocketMqChannelProviderTest {


    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("host","localhost:9876");
        RocketMqChannelConfig config = new RocketMqChannelConfig(properties);

        ChannelProvider channelProvider = new RocketMqChannelProvider(config);


        EventConfigItem a = new EventConfigItem();
        a.setChannelProvider(channelProvider);
        a.setEventName(A.EVENT_NAME);
        EventConfigManager.addEventSubcriberConfigItem(a);

        EventConfigItem b = new EventConfigItem();
        b.setChannelProvider(channelProvider);
        b.setEventName(B.EVENT_NAME);
        EventConfigManager.addEventSubcriberConfigItem(b);

        channelProvider.init();

        EventBus.register(new  A());
        EventBus.register(new  B());

        String eventName = "";
        Scanner scanner  = new Scanner(System.in);
        while (!(eventName = scanner.next()).equals("exit")){
            try {
                String[] split = eventName.split(":");
                EventBus.publish(split[0], split[1]);
            }catch (Exception e){

            }
        }
    }
}


class A implements EventHandler<String> {
    public static String EVENT_NAME = "AA";
    public void handler(String s) {
        System.out.println(EVENT_NAME+"收到消息:"+s);
    }

    public String getEventName() {
        return EVENT_NAME;
    }
}




class B implements EventHandler<String>{
    public static String EVENT_NAME = "BB";
    public void handler(String s) {
        System.out.println(EVENT_NAME+"收到消息:"+s);
    }

    public String getEventName() {
        return EVENT_NAME;
    }
}