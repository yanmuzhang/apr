package cn.liberfree.de;

import cn.liberfree.de.config.ContextConfig;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zhangchao
 * @time: 2018-08-07 10:54
 **/
public  class ObjectFactory {

    private static Map<Class<ContextConfig>,ContextConfig> objectHashMap = new ConcurrentHashMap<Class<ContextConfig>,ContextConfig>();

//
    public static  ContextConfig getContextConfig() {
        synchronized (objectHashMap) {
            if (objectHashMap.containsKey(ContextConfig.class)) {
                return objectHashMap.get(ContextConfig.class);
            }
            ContextConfig contextConfig = null;
            ServiceLoader<ContextConfig> serviceLoader = ServiceLoader.load(ContextConfig.class);
            Iterator<ContextConfig> searchs = serviceLoader.iterator();
            if (searchs.hasNext()) {
                contextConfig = searchs.next();
                objectHashMap.put(ContextConfig.class,contextConfig);
            }
            return contextConfig;
        }
    }

}
