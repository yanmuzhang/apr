package com.cloud.ddd;

import com.cloud.ddd.repository.EntityObject;
import com.cloud.ddd.repository.RepositoryLink;

/**
 * @author: zhangchao
 * @time: 2018-08-28 15:54
 **/
@RepositoryLink(UserRepository.class)
public class User extends EntityObject<String> {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User() {
    }

    public User(String id,String name) {
        this.name = name;
        super.setId(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
