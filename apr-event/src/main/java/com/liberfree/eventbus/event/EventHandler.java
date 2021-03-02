package com.liberfree.eventbus.event;

/**
 * @author: zhangchao
 * @time: 2018-12-20 10:11
 **/
public interface EventHandler<T> {

    void handler(T t);

    String getEventName();

}
