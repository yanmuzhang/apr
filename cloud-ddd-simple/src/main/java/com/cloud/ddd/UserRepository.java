package com.cloud.ddd;

import com.cloud.ddd.loader.EntityLoader;
import com.cloud.ddd.repository.EntityObject;
import com.cloud.ddd.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-28 15:55
 **/
public class UserRepository implements IRepository<User> {


    List<User> userList = new ArrayList<User>();
    {
        userList.add(new User("1","小明"));
        userList.add(new User("2","小白"));
        userList.add(new User("3","小黑"));
        userList.add(new User("4","小黄"));
    }


    public User load(Object id, EntityLoader loader) {
        User object = loader.create(User.class);
        User user1 = userList.stream().filter(user -> user.getId().equals(id.toString())).findFirst().orElse(null);
        if(user1 == null){
            throw new NullPointerException("User不存在");
        }
        object.setName(user1.getName());
        return object;
    }

    public void save(User object) {
        System.out.println(object);
    }

    public void delete(Object id) {
        System.out.println(id);
    }
}
