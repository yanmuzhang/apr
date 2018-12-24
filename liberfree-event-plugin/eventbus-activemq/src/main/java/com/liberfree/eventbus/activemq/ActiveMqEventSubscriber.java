package com.liberfree.eventbus.activemq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liberfree.eventbus.event.EventHandler;
import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
                    log.info("Class:{},事件:{},开启订阅 .",getEventHandler().getClass().getName(),getEventHandler().getEventName());
                    while (running){
                        try {
                            TextMessage textMessage = (TextMessage)consumer.receive(200 );
                            if(textMessage != null){
                                String text = textMessage.getText();
                                EventHandler eventHandler = getEventHandler();
                                MessageData messageData = (MessageData)toObject(text, MessageData.class);
                                Class<?> eventDataObjectClass = getEventDataObjectClass();
                                Object data = toObject(String.valueOf(messageData.getData()), eventDataObjectClass);
                                eventHandler.handler(data);
                                textMessage.acknowledge();
                            }
                        } catch (Exception e) {
                            log.error("无法解析的消息 .");
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

    public Class<?> getEventDataObjectClass(){
        EventHandler eventHandler = getEventHandler();
        Type type = eventHandler.getClass().getGenericInterfaces()[0];
        if(type instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            return (Class<?>)actualTypeArgument;
        }
        return null;
    }

    public void stop() {
        this.running = false;
    }


}
