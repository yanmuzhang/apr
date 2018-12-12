package cn.liberfree.de.loader;

import cn.liberfree.de.repository.BaseEntityObject;
import cn.liberfree.de.repository.EntityObject;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: zhangchao
 * @time: 2018-08-01 11:08
 **/
public class EntityMethodInterceptor implements MethodInterceptor,Serializable {
    private static final long serialVersionUID = -2512752626056722876L;
    private static final String METHOD_ADD_TO_UNITOFWORK = "addToUnitOfWork";
    private static final String[] withoutMethod = new String[]{"hashCode", "equals", "toString", "notify", "notifyAll", "wait"};
    private static final Logger logger = LoggerFactory.getLogger(EntityMethodInterceptor.class);


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = methodProxy.invokeSuper(o, objects);
        if (method.getModifiers() == 1 && !Arrays.asList(withoutMethod).contains(method.getName()) && !method.getName().startsWith("get") && !method.getName().startsWith("is")) {
            Field field = BaseEntityObject.class.getDeclaredField(BaseEntityObject.IS_LOAD);
            field.setAccessible(true);
            if (!field.getBoolean(o)) {
                Method method1 = EntityObject.class.getDeclaredMethod(METHOD_ADD_TO_UNITOFWORK);
                method1.setAccessible(true);
                method1.invoke(o);
                this.logger.info("实体{}发生更改，调用方法{}" ,o.getClass().getName(),method.getName());
            }
        }
        return obj;
    }
}
