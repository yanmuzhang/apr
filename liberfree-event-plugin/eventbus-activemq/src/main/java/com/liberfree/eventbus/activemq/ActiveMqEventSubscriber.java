package com.liberfree.eventbus.activemq;

import com.liberfree.eventbus.event.EventHandler;
import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * @author: zhangchao
 * @time: 2018-12-21 16:38
 **/
public class ActiveMqEventSubscriber extends EventSubscriber  {

    private final static Logger log = LoggerFactory.getLogger(ActiveMqEventSubscriber.class);

    private boolean running = true;

    private ActiveMqChannelProvider channelProvider;

    public ActiveMqEventSubscriber(ActiveMqChannelProvider channelProvider) {
        this.channelProvider = channelProvider;
    }

    public void start() {
        this.running = true;
        new Thread(new Runnable() {
            public void run() {
                Session session = null;
                Connection connection = null;
                Queue queue = null;
                MessageConsumer consumer = null;
                try {
                    ActiveMQConnectionFactory factory = channelProvider.getConnectionFactory();
                    // 通过工厂创建一个连接
                    connection = factory.createConnection();
                    // 启动连接
                    connection.start();
                    // 创建一个session会话
                    session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
                    // 创建一个消息队列
                    queue = session.createQueue(getEventHandler().getEventName());
                    // 创建消息制作者
                    consumer = session.createConsumer(queue);
                    log.info("Class:{},eventName:{},enable subscriber .",getEventHandler().getClass().getName(),getEventHandler().getEventName());
                    while (running){
                        try {
                            TextMessage textMessage = (TextMessage)consumer.receive(200 );
                            if(textMessage != null){
                                String text = textMessage.getText();
                                EventHandler eventHandler = getEventHandler();
                                MessageData messageData = (MessageData)toObject(text, MessageData.class);
                                Object data = toObject(String.valueOf(messageData.getData()), getEventDataObjectClass());
                                eventHandler.handler(data);
                                //上报已读
                                textMessage.acknowledge();
                            }
                        } catch (Exception e) {
                            log.error("error to parse message.");
                            e.printStackTrace();
                            session.recover();
                        }
                    }
                    consumer.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }finally {
                    if(consumer != null){
                        try {
                            consumer.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                    if(session != null){
                        try {
                            session.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                    if(connection != null){
                        try {
                            connection.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }



    public void stop() {
        this.running = false;
    }


}
