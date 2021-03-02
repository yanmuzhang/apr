package com.liberfree.eventbus.channel.def;

import com.liberfree.eventbus.message.MessageData;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-12-21 16:11
 **/
public class DefaultEventSource {

    Set<DefaultEventListenner> defaultEventListenners = new HashSet<>();

    public void addDefaultEventListenner(DefaultEventListenner defaultEventListenner){
        defaultEventListenners.add(defaultEventListenner);
    }


    public void clearAll(){defaultEventListenners.clear();}

    public void send(String eventName, MessageData messageData){
        Iterator<DefaultEventListenner> iterator = defaultEventListenners.iterator();
        while (iterator.hasNext()){
            DefaultEventListenner next = iterator.next();
            next.onEvent(eventName,messageData);
        }
    }



}
