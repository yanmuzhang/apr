package com.liberfree.eventbus.message;

import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-12-21 10:59
 **/
public class MessageData{

    private String messageId;
    private Object data;

    public MessageData() {
    }


    public static MessageData createMessageData(Object data){
        MessageData messageData = new MessageData();
        messageData.setData(data);
        messageData.setMessageId(UUID.randomUUID().toString());
        return messageData;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
