package cn.liberfree.de.core;

public interface BeanFactory extends Context {

    public <T> T getBean(Class<T> tClass);

}
