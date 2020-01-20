package com.liberfree.eventbus.redis;

import com.liberfree.eventbus.event.EventSubscriber;
import com.liberfree.eventbus.message.MessageData;
import redis.clients.jedis.Jedis;

import java.util.Optional;

/**
 * @author: zhangchao
 * @time: 2018-12-25 10:42
 **/
public class RedisEventSubscriber extends EventSubscriber {

    private RedisChannelProvider redisChannelProvider;


    private boolean running;

    public RedisEventSubscriber(RedisChannelProvider redisChannelProvider) {
        super();
        this.redisChannelProvider = redisChannelProvider;
    }

    public void start() {
        running = true;
        new Thread(new Runnable() {
            public void run() {
                RedisTemplate redisTemplate = redisChannelProvider.getRedisTemplate();
                while (running){
                    try {
                        redisTemplate.execute(new RedisTemplate.RedisCmd() {
                            public void cmd(Jedis jedis) {
                                Optional<String> optional = Optional.ofNullable(jedis.rpop(getEventHandler().getEventName()));
                                if(optional.isPresent()){
                                    MessageData messageData = (MessageData)toObject(optional.get(), MessageData.class);
                                    Object data = toObject(String.valueOf(messageData.getData()), getEventDataObjectClass());
                                    eventHandler.handler(data);
                                }
                            }
                        });
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void stop() {
        running = false;
    }
}
