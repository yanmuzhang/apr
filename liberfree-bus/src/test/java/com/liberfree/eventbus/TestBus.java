package com.liberfree.eventbus;

import com.alibaba.fastjson.JSON;
import com.liberfree.eventbus.channel.ChannelProvider;
import com.liberfree.eventbus.channel.def.DefaultChannelProvider;
import com.liberfree.eventbus.event.EventHandler;
import com.liberfree.eventbus.event.EventPublish;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * @author: zhangchao
 * @time: 2018-12-21 13:55
 **/
public class TestBus {






    public static void main(String[] args)  throws Exception{






//
//
//
//        ChannelProvider channelProvider = new DefaultChannelProvider();
//        channelProvider.init();
//        EventBus.register(new EventHandler() {
//            @Override
//            public void handler(Object o) {
//                System.out.println("收到A事件："+JSON.toJSONString(o));
//            }
//
//            @Override
//            public String getEventName() {
//                return "A";
//            }
//        });
//
//        EventBus.register(new EventHandler() {
//            @Override
//            public void handler(Object o) {
//                System.out.println("收到B事件："+JSON.toJSONString(o));
//            }
//
//            @Override
//            public String getEventName() {
//                return "B";
//            }
//        });
//
//        String eventName = "";
//
//        Scanner scanner  = new Scanner(System.in);
//        while (!(eventName = scanner.next()).equals("exit")){
//            String[] split = eventName.split(":");
//            EventBus.publish(split[0],split[1]);
//        }


        Type type = UserHandler.class.getGenericInterfaces()[0];
        System.out.println(type.getClass().getName());
        if(type instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            System.out.println(actualTypeArgument);
            System.out.println(actualTypeArgument.getTypeName());
        }
    }


}

class UserHandler implements EventHandler<EventPublish>{
    @Override
    public void handler(EventPublish eventPublish) {

    }

    @Override
    public String getEventName() {
        return null;
    }
}
