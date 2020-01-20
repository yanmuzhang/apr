package com.liberfree.eventbus.kafka;

import com.liberfree.eventbus.EventBus;
import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.config.EventConfigItem;
import com.liberfree.eventbus.config.EventConfigManager;
import com.liberfree.eventbus.event.EventHandler;
import com.liberfree.eventbus.event.EventHandlerData;
import com.liberfree.eventbus.utils.GsonUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class KafkaChannelProviderTest {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("host","192.168.4.211:9092");
        properties.setProperty("queueName","TEST_TOPIC");
        KafkaChannelConfig config = new KafkaChannelConfig(properties);
        ChannelProvider channelProvider = new KafkaChannelProvider(config);
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
        scanner.useDelimiter("\n");
        while (!(eventName = scanner.next()).equals("exit")){
            try {
                String[] split = eventName.split(":");
                String topic = split[0];
                StringBuffer content = new StringBuffer();
                List<String> collect = Arrays.asList(split).stream().filter(i -> !i.equals(topic)).collect(Collectors.toList());
                String join = String.join(content, collect);
                EventBus.publish(topic,new StringData(join));
            }catch (Exception e){

            }
        }
    }
}


class A implements EventHandler<StringData> {
    public static String EVENT_NAME = "AA";
    public void handler(StringData s) {
        System.out.println(A.EVENT_NAME+"收到消息:"+s.getValue());
    }

    public String getEventName() {
        return A.EVENT_NAME;
    }
}

class B implements EventHandler<StringData>{
    public static String EVENT_NAME = "BB";
    public void handler(StringData s) {
        System.out.println(B.EVENT_NAME+"收到消息:"+s.getValue());
    }

    public String getEventName() {
        return B.EVENT_NAME;
    }
}

class StringData implements EventHandlerData{
    private String value;

    public StringData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}