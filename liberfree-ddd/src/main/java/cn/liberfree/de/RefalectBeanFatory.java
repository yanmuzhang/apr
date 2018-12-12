package cn.liberfree.de;

import cn.liberfree.common.utils.ReflectUtils;
import cn.liberfree.de.core.BeanFactory;

/**
 * @author: zhangchao
 * @time: 2018-08-03 14:34
 **/
public class RefalectBeanFatory implements BeanFactory {
    @Override
    public <T> T getBean(Class<T> tClass) {
        return (T)ReflectUtils.reflect(tClass).newInstance().get();
    }

    @Override
    public Class getObjectClass() {
        return RefalectBeanFatory.class;
    }
}
