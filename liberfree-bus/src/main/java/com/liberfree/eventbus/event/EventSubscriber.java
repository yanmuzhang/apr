package com.liberfree.eventbus.event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

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
