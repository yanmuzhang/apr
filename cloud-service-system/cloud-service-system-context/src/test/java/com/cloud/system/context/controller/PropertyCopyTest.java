package com.cloud.system.context.controller;

import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.BeanUtils;

/**
 * @author: zhangchao
 * @time: 2018-08-27 15:43
 **/
public class PropertyCopyTest  {

    public static void main(String[] args) {
        User user  = new User();
        user.setName("Juck");
        user.setId("i");
        UserDto userDto =new UserDto();
        BeanUtils.copyProperties(user,userDto);
        System.out.println(userDto);
        userDto =new UserDto();
        BeanCopier.create(User.class,UserDto.class,false).copy(user,userDto,null);
        System.out.println(userDto);



        user  = new User();

        BeanCopier.create(UserDto.class,User.class,false).copy(userDto,user,null);
        System.out.println(user);
        user  = new User();
        BeanUtils.copyProperties(userDto,user);
        System.out.println(user);


//        Admin admin = new Admin();
//        admin.setId("1");
//        admin.setName("admin");
//        admin.setAge(Short.valueOf("2121"));
//        admin.setUsername("admin");
//        System.out.println(JsonUtils.toJSONNoFeatures(admin));
//        AdminDto adminDto = new AdminDto();
//        BeanUtils.copyProperties(admin,adminDto);
//        System.out.println(JsonUtils.toJSONNoFeatures(adminDto));


    }



}


class UserDto{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class User extends Base<String>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}

abstract class Base<T>{
    private T id;

    public  T  getId() {
        return id;
    }

    public void setId( T  id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                '}';
    }
}