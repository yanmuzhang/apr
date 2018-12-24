package com.liberfree.eventbus.activemq;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @author: zhangchao
 * @time: 2018-12-21 16:37
 **/
public class ActiveMqChannelProvider extends ChannelProvider {

    private final static Logger log = LoggerFactory.getLogger(ActiveMqEventSubscriber.class);

    //默认连接用户名
    private  String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private  String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private  String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private ActiveMQConnectionFactory connectionFactory;
//    private Connection connection;
//    private Session session;


    public ActiveMqChannelProvider(String BROKEN_URL, String USERNAME, String PASSOWRD) {
        this.BROKEURL = BROKEN_URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSOWRD;
    }

//    public Session getSession() {
//        return session;
//    }

    public void init() {
        try {
            log.info("=====================");
            log.info("USERNAME:"+USERNAME);
            log.info("PASSWORD:"+PASSWORD);
            log.info("BROKEURL:"+BROKEURL);
            log.info("=====================");
//            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);
            connectionFactory = new ActiveMQConnectionFactory(BROKEURL);
            log.info("init activemq success ");
        } catch (Exception e) {
            log.error("init activemq error");
            e.printStackTrace();
        }
    }

    public ActiveMQConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public EventSubscriber createEventSubscriber() {
        return new ActiveMqEventSubscriber(this);
    }

    public EventPublish createEventPublish() {
        return new ActiveMqEventPublish(this);
    }
}
