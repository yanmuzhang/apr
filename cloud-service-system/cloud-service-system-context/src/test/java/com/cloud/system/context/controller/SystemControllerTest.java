package com.cloud.system.context.controller;

import com.cloud.ddd.loader.EntityLoader;
import com.cloud.system.context.repository.model.Admin;

public class SystemControllerTest {


    public static void main(String[] args) {
        EntityLoader loader = new EntityLoader();

        Admin entityObject = loader.create(Admin.class);

        System.out.println(entityObject.getName());
    }

}
