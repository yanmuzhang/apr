package com.liberfree.eventbus.kafka;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.message.MessageData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

import static com.liberfree.eventbus.utils.GsonUtils.toJsonString;

/**
 * @author: zhangchao
 * @time: 2019-01-02 10:35
 **/
public class KafkaEventPublish extends EventPublish {

    private KafkaChannelConfig channelConfig;

    private KafkaProducer<String, String> producer;

    public KafkaEventPublish(ChannelProvider channelProvider) {
        super(channelProvider);
        this.channelConfig = (KafkaChannelConfig)channelProvider.getChannelConfig();
    }

    public KafkaProducer<String, String> createKafkaProducer(){
        if(producer != null){
            return producer;
        }
        Properties props = channelConfig.getProperties();
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        producer = new KafkaProducer<>(props);
        return producer;
    }


    @Override
    public void publishMessage() {
        KafkaProducer<String, String> producer = createKafkaProducer();
        MessageData messageData = getMessageData();
        String msg = toJsonString(messageData);
        producer.send(new ProducerRecord<>(getEventName(),msg));
    }
}
