package com.liberfree.eventbus.redis;

import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.event.EventPublish;
import com.liberfree.eventbus.event.EventSubscriber;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-12-24 17:28
 **/
public class RedisChannelProvider extends ChannelProvider<RedisChannelConfig> {

    private Pool pool;
    private RedisTemplate redisTemplate;

    public RedisChannelProvider(RedisChannelConfig channelConfig) {
        super(channelConfig);
    }

    public void init() {
        RedisChannelConfig redisChannelConfig = getChannelConfig();

        Set<String> hosts = new HashSet<String>();
        hosts.addAll(redisChannelConfig.getHosts());
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redisChannelConfig.getMaxIdle());
        config.setMaxTotal(redisChannelConfig.getMaxTotal());
        if(hosts.size() > 1){
            pool = new JedisSentinelPool(redisChannelConfig.getMasterName(), hosts, config);
        }else{
            Iterator<String> iterator = hosts.iterator();
            if(iterator.hasNext()){
                String next = iterator.next();
                HostAndPort hostAndPort = HostAndPort.parseString(next);
                pool = new JedisPool(hostAndPort.getHost(),hostAndPort.getPort());
            }
        }
        redisTemplate  = new RedisTemplate(pool);
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public EventSubscriber createEventSubscriber() {
        return new RedisEventSubscriber(this);
    }

    public EventPublish createEventPublish() {
        return new RedisEventPublish(this);
    }
}
