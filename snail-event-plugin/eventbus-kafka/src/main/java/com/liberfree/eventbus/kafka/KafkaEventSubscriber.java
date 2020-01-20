package com.liberfree.eventbus.kafka;

import com.liberfree.eventbus.event.EventHandlerData;
import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import static com.liberfree.eventbus.utils.GsonUtils.toJsonString;
import static com.liberfree.eventbus.utils.GsonUtils.toObject;

/**
 * @author: zhangchao
 * @time: 2019-01-02 10:34
 **/
public class KafkaEventSubscriber extends EventSubscriber {

    private KafkaChannelProvider kafkaChannelProvider;

    private boolean running;

    public KafkaEventSubscriber(KafkaChannelProvider kafkaChannelProvider) {
        super();
        this.kafkaChannelProvider = kafkaChannelProvider;
    }

    @Override
    public void start() {
        running = true;
        KafkaChannelConfig channelConfig = this.kafkaChannelProvider.getChannelConfig();
        Properties props = channelConfig.getProperties();
        props.put("group.id", getEventHandler().getEventName());
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(getEventHandler().getEventName()) );
//        consumer.subscribe(Arrays.asList(getEventHandler().getEventName()),new ConsumerRebalanceListener() {
//            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
//            }
//            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
//                //将偏移设置到最开始
//                consumer.seekToBeginning(collection);
//            }
//        });
        new Thread(new Runnable() {
            public void run() {
                while (running) {
                    try {
                        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                        for (ConsumerRecord<String, String> record : records) {

                            String json = new String(record.value());
                            MessageData messageData = (MessageData) toObject(json, MessageData.class);
                            Object o =  toObject(toJsonString(messageData.getData()),getEventDataObjectClass());
                            getEventHandler().handler(o);
                        }
                        consumer.commitAsync();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void stop()  {
        running = false;
    }
}
