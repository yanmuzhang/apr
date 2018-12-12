package com.cloud.ddd;

import com.cloud.ddd.loader.EntityLoader;
import com.cloud.ddd.repository.EntityObject;

/**
 * @author: zhangchao
 * @time: 2018-08-28 15:54
 **/
public class simple {


    public static void main(String[] args) {
        EntityLoader loader = new EntityLoader();
        System.out.println(loader.load("1", User.class));
        User load = loader.load("1", User.class);
        load.setName("new");
        System.out.println(loader.load("1", User.class));
        System.out.println(loader.load("1", User.class));
        System.out.println(loader.load("1", User.class));
        System.out.println(loader.load("1", User.class));
        System.out.println(loader.load("1", User.class));
        System.out.println(loader.load("1", User.class));
    }


}
