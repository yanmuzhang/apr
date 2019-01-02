package com.liberfree.eventbus.kafka;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2019-01-02 10:33
 **/
public class KafkaChannelProvider extends ChannelProvider<KafkaChannelConfig> {

    private String SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    private String DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";

    public KafkaChannelProvider(KafkaChannelConfig channelConfig) {
        super(channelConfig);
    }

    @Override
    public void init() {
        Properties props = getChannelConfig().getProperties();
        props.put("bootstrap.servers", getChannelConfig().getHost());
        props.put("key.serializer", SERIALIZER);
        props.put("key.deserializer", DESERIALIZER);
        props.put("value.serializer", SERIALIZER);
        props.put("value.deserializer", DESERIALIZER);
    }

    @Override
    public EventSubscriber createEventSubscriber() {
        return new KafkaEventSubscriber(this);
    }

    @Override
    public EventPublish createEventPublish() {
        return new KafkaEventPublish(this);
    }
}
