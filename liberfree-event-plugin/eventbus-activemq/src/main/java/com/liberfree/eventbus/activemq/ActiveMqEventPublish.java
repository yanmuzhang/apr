package com.liberfree.eventbus.activemq;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * @author: zhangchao
 * @time: 2018-12-21 16:38
 **/
public class ActiveMqEventPublish extends EventPublish {

    private final static Logger log = LoggerFactory.getLogger(ActiveMqEventSubscriber.class);

    public ActiveMqEventPublish(ChannelProvider channelProvider) {
        super(channelProvider);
    }

    public void publishMessage() {
        String jsonString = toJsonString(getMessageData());
        try {
            ActiveMqChannelProvider channelProvider = (ActiveMqChannelProvider)getChannelProvider();
            Connection connection = channelProvider.getConnectionFactory().createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            Destination topic = session.createQueue(  getEventName());
            MessageProducer producer = session.createProducer(topic);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(session.createTextMessage(jsonString));
            producer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            log.error("发送ActiveMQ消息失败!{}:{}",getEventName(),jsonString);
            e.printStackTrace();
        }
    }



}
