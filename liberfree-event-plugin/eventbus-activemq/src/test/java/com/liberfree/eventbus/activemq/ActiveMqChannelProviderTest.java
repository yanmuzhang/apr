package com.liberfree.eventbus.activemq;

import com.liberfree.eventbus.EventBus;
import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.config.EventConfigItem;
import com.liberfree.eventbus.config.EventConfigManager;
import com.liberfree.eventbus.event.EventHandler;
import org.apache.activemq.ActiveMQConnection;

import java.util.Scanner;

public class ActiveMqChannelProviderTest {
    //默认连接用户名
    private static String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ChannelProvider channelProvider = new ActiveMqChannelProvider(BROKEURL,USERNAME,PASSWORD);

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
        EventBus.register(new  A());
        EventBus.register(new  B());
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


class A implements EventHandler<String>{
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