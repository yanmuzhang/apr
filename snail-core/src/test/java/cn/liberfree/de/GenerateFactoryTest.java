package cn.liberfree.de;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

public class GenerateFactoryTest {
    private static final Logger logger = LoggerFactory.getLogger(GenerateFactoryTest.class);

    public static void main(String[] args) {
//        Generate generate = GenerateFactory.newGenerate();
//        System.out.println(generate.id());
//        ContextConfig contextConfig = ObjectFactory.getContextConfig();
//        System.out.println(contextConfig.getGenerate().id());

        CachingProvider cachingProvider = Caching.getCachingProvider();

        CacheManager cacheManager = cachingProvider. getCacheManager();

        MutableConfiguration<String, String> config = new MutableConfiguration();

        Cache<String, String> cache = cacheManager.createCache("JDKCodeNames",config);

        cache.put("JDK1.5","Tiger");

        cache.put("JDK1.6","Mustang");

        cache.put("JDK1.7","Dolphin");

        String jdk7CodeName = cache.get("JDK1.7");
    }
}
