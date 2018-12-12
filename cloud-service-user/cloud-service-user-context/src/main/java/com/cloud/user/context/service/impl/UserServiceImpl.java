package com.cloud.user.context.service.impl;

import com.cloud.common.IdentifyUtils;
import com.cloud.common.page.Page;
import com.cloud.ddd.loader.EntityLoader;
import com.cloud.user.api.dto.UserDto;
import com.cloud.user.context.repository.mappers.UserDmoMapper;
import com.cloud.user.context.repository.mappers.dmo.UserDmo;
import com.cloud.user.context.repository.mappers.dmo.UserDmoExample;
import com.cloud.user.context.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-07-30 18:07
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private EntityLoader entityLoader;

    @Autowired
    private UserDmoMapper userDmoMapper;


//    @Override
//    public User load(String id) {
//        return entityLoader.load(id,User.class);
//    }

    @Override
    public String login(String username, String password) {
//        UserDmo userDmo = userDmoMapper.selectByPrimaryKey("11");
//        return userDmo == null?null:userDmo.getId();
        UserDmoExample example = new UserDmoExample();
        example.createCriteria().andNameEqualTo(username).andPasswordEqualTo(DigestUtils.md5DigestAsHex(password.getBytes()));
        List<UserDmo> userDmos = userDmoMapper.selectByExample(example);
        return userDmos.size() > 0 ? userDmos.get(0).getId() : null;
    }

    @Override
    public void save(UserDto user) {
        UserDmo userDmo = new UserDmo();
        BeanUtils.copyProperties(user,userDmo);
        userDmo.setId(IdentifyUtils.uuid());
        userDmo.setCreateTime(new Date());
        userDmo.setUpdateTime(new Date());
        userDmo.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        int insert = userDmoMapper.insert(userDmo);
    }

    @Override
    public Page<UserDto> list(Page<UserDto> page) {
        List<UserDmo> userDmos = userDmoMapper.selectByExample(new UserDmoExample());



        return null;
    }
}
