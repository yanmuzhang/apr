package com.liberfree.eventbus.kafka;

import com.liberfree.eventbus.channel.ChannelConfig;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2019-01-02 10:33
 **/
public class KafkaChannelConfig extends ChannelConfig {


    private String DEFAULT_HOST = "localhost:9092";
    private String DEFAULT_QUEUE_NAME = getClass().getSimpleName().toUpperCase();

    private String host;
    private String queueName;

    public KafkaChannelConfig(Properties properties) {
        super(properties);
        this.host = properties.getProperty("host",DEFAULT_HOST);
        this.queueName = properties.getProperty("queueName",DEFAULT_QUEUE_NAME);
    }

    public String getHost() {
        return host;
    }

    public String getQueueName() {
        return queueName;
    }
}
