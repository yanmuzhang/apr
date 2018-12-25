package com.liberfree.eventbus.redis;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author: zhangchao
 * @time: 2018-12-25 10:43
 **/
public class RedisEventPublish extends EventPublish {

    public final static Logger log = LoggerFactory.getLogger(RedisEventPublish.class);

    public RedisEventPublish(ChannelProvider channelProvider) {
        super(channelProvider);
    }

    public void publishMessage() {
        RedisChannelProvider channelProvider = (RedisChannelProvider)getChannelProvider();
        RedisTemplate redisTemplate = channelProvider.getRedisTemplate();
        redisTemplate.execute(new RedisTemplate.RedisCmd() {
            public void cmd(Jedis jedis) {
                Long lpush = jedis.lpush(getEventName(), toJsonString(getMessageData()));
                log.info("list length {}",lpush);
            }
        });
    }
}
