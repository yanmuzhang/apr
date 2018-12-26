package com.liberfree.eventbus.rocketmq;

import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-12-26 15:42
 **/
public class RocketMqEventSubscriber extends EventSubscriber {

    private RocketMqChannelProvider rocketMqChannelProvider;
    private DefaultMQPushConsumer consumer;

    public RocketMqEventSubscriber(RocketMqChannelProvider rocketMqChannelProvider) {
        this.rocketMqChannelProvider = rocketMqChannelProvider;
    }

    @Override
    public void start() {
        try {
            RocketMqChannelConfig channelConfig = rocketMqChannelProvider.getChannelConfig();
            // Instantiate with specified consumer group name.
            this.consumer = new DefaultMQPushConsumer(getEventHandler().getEventName());
//            this.consumer = new DefaultMQPushConsumer();

            // Specify name server addresses.
            this.consumer.setNamesrvAddr(channelConfig.getHost());

            // Subscribe one more more topics to consume.
            this.consumer.subscribe(getEventHandler().getEventName(), "*");
            // Register callback to execute on arrival of messages fetched from brokers.
            this.consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    try {
                        if(msgs != null && msgs.size() > 0){
                            for (MessageExt msg : msgs) {
                                String message = StringUtils.toEncodedString(msg.getBody(), Charset.forName("UTF-8"));
                                MessageData messageData = (MessageData)toObject(message, MessageData.class);
                                Object data = toObject(String.valueOf(messageData.getData()), getEventDataObjectClass());
                                getEventHandler().handler(data);
                            }
                        }
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
            });
            //Launch the consumer instance.
            this.consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        this.consumer.shutdown();
    }
}
