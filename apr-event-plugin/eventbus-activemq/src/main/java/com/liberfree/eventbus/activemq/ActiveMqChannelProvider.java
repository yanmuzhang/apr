package com.liberfree.eventbus.activemq;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhangchao
 * @time: 2018-12-21 16:37
 **/
public class ActiveMqChannelProvider extends ChannelProvider<ActiveMqChannelConfig> {

    private final static Logger log = LoggerFactory.getLogger(ActiveMqChannelProvider.class);

    private ActiveMQConnectionFactory connectionFactory;

    public ActiveMqChannelProvider(ActiveMqChannelConfig channelConfig) {
        super(channelConfig);
    }

    @Override
    public void init() {
        try {
            ActiveMqChannelConfig config = getChannelConfig();
            log.info("=====================");
            log.info("url:" + config.getUrl());
            log.info("username:" + config.getUsername());
            log.info("password:" + config.getPassword());
            log.info("=====================");
            if(config.getUsername() == null|| "".equals(config.getUsername())){
                connectionFactory = new ActiveMQConnectionFactory(config.getUrl());
            }else{
                connectionFactory = new ActiveMQConnectionFactory(config.getUsername(),config.getPassword(),config.getUrl());
            }
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
