package com.liberfree.eventbus.event;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
}
