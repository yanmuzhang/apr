package com.cloud.user.context.repository.model;

import com.cloud.ddd.loader.EntityLoader;
import com.cloud.ddd.repository.IRepository;
import com.cloud.user.context.repository.User;
import com.cloud.user.context.repository.mappers.UserDmoMapper;
import com.cloud.user.context.repository.mappers.dmo.UserDmo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-08-03 11:50
 **/
@Component
public class UserRepository implements IRepository<User> {


    @Autowired
    UserDmoMapper userDmoMapper;



    @Override
    public User load(Object id, EntityLoader loader) {
        UserDmo userDmo = userDmoMapper.selectByPrimaryKey(id.toString());
        if(userDmo == null){
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userDmo,user);
        return user;
    }

    @Override
    public void save(User object) {
        if(object == null){
            throw new NullPointerException("User is null");
        }
        UserDmo userDmo = new UserDmo();
        BeanUtils.copyProperties(object,userDmo);

        if(userDmoMapper.updateByPrimaryKey(userDmo) == 0){
            userDmoMapper.insert(userDmo);
        }
    }

    @Override
    public void delete(Object id) {
        userDmoMapper.deleteByPrimaryKey(id.toString());
    }
}
