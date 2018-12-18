package cn.liberfree.de.spring;

import cn.liberfree.de.ObjectFactory;
import cn.liberfree.de.config.DefaultContextConfig;
import cn.liberfree.de.core.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * @author: zhangchao
 * @time: 2018-08-22 16:46
 **/
@Configuration
@ComponentScan
@EnableTransactionManagement
public class DeConfiguretion implements ApplicationContextAware {

    public final static Logger logger  = LoggerFactory.getLogger(DeConfiguretion.class);

    private ApplicationContext context ;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        logger.info("load ddd success 。。。");
    }

    @PostConstruct
    public void init(){
        ((DefaultContextConfig) ObjectFactory.getContextConfig()).setBeanFactory(new BeanFactory() {
            @Override
            public <T> T getBean(Class<T> tClass) {
                return context.getBean(tClass);
            }

            @Override
            public Class getObjectClass() {
                return getClass();
            }
        });
    }
}
