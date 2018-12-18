package cn.liberfree.de.core;

import cn.liberfree.de.loader.BaseEntityLoader;
import cn.liberfree.de.loader.EntityMethodInterceptor;
import cn.liberfree.de.repository.BaseEntityObject;
import cn.liberfree.de.repository.EntityObject;
import net.sf.cglib.proxy.Enhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author: zhangchao
 * @time: 2018-11-16 11:47
 **/
public class EntityObjectUtils {

    public static final Logger log = LoggerFactory.getLogger(BaseEntityLoader.class);

    public static <T extends EntityObject> T create(Class<T> tClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(new EntityMethodInterceptor());
        Object o = null;
        try {
            o = enhancer.create();
        } catch (Exception e) {
            log.error("createProxy {}",e);
            throw  new SystemExecption(e);
        }
        return (T)o;
    }

    public static void setValue(Class clazz, BaseEntityObject entityObject, String fieldName, Object value) {
        try {
            Field declaredField = clazz.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            declaredField.set(entityObject, value);
        } catch (Exception var5) {
            log.warn("set attr failed", var5);
        }

    }

}
