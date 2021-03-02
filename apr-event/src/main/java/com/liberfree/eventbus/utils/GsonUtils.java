package com.liberfree.eventbus.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2019-01-02 17:11
 **/
public class GsonUtils {

    public static String toJsonString(Object object) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
        return gson.toJson(object);
    }

    public static Object toObject(String content,Class c){
        Gson gson = new GsonBuilder().disableHtmlEscaping().setLenient().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
        return  gson.fromJson(content, c);
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","fefe fejafwe");

        System.out.println(toJsonString(map));
    }
}
