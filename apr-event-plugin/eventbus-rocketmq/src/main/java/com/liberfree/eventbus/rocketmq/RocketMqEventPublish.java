package com.liberfree.eventbus.rocketmq;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.Charset;

/**
 * @author: zhangchao
 * @time: 2018-12-26 15:43
 **/
public class RocketMqEventPublish extends EventPublish {

    private DefaultMQProducer producer;

    public RocketMqEventPublish(ChannelProvider channelProvider) {
        super(channelProvider);
    }


    private DefaultMQProducer getDefaultMQProducer(){
        if(producer == null){
            try {
                RocketMqChannelProvider rocketMqChannelProvider = (RocketMqChannelProvider)getChannelProvider();
                RocketMqChannelConfig channelConfig = rocketMqChannelProvider.getChannelConfig();
                producer = new DefaultMQProducer(getEventName());
                producer.setNamesrvAddr(channelConfig.getHost());
                producer.start();
                return null;
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
        return producer;
    }







    @Override
    public void publishMessage() {
        try {
            Message msg = new Message(getEventName(), getEventName() ,  toJsonString(getMessageData()).getBytes(Charset.forName("UTF-8")) );
            this.getDefaultMQProducer().sendOneway(msg);
//            this.producer.shutdown();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
