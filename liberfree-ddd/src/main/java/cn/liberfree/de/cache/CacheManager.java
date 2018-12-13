package cn.liberfree.de.cache;

import javax.cache.Cache;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-08-23 17:30
 **/
public final class CacheManager {

    private static Cache<Serializable, Object> cache;

    public static final String CAHCE_NAME = "APPLICATION_";

    static {
        CachingProvider cachingProvider = Caching.getCachingProvider();

        javax.cache.CacheManager cacheManager = cachingProvider. getCacheManager();

        MutableConfiguration<Serializable, Object> config = new MutableConfiguration();

        cache = cacheManager.createCache("application",config);
    }

    public static boolean containsKey(Serializable key){
        return cache.containsKey(CAHCE_NAME+key);
    }

    public static Object get(Serializable key){
        return cache.get(CAHCE_NAME+key);
    }

    public static void set(Serializable key,Object object){
        cache.put(CAHCE_NAME + key,object);
    }
    public static void remove(Serializable key){
        if(containsKey(key)){
            cache.remove(CAHCE_NAME + key);
        }
    }


}
