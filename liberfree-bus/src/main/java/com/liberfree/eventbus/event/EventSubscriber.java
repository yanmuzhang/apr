package com.liberfree.eventbus.event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class EventSubscriber {

    public EventHandler eventHandler;

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract void start();

    public abstract void stop();

    protected   Object toObject(String content,Class c){
        Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
        return  gson.fromJson(content, c);
    }

    public Class<?> getEventDataObjectClass(){
        EventHandler eventHandler = getEventHandler();
        Type type = eventHandler.getClass().getGenericInterfaces()[0];
        if(type instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            return (Class<?>)actualTypeArgument;
        }
        return null;
    }
}
