package com.cloud.webapi.context.service.impl;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OperatorClient;
import com.cloud.ccb.api.dto.*;
import com.cloud.webapi.context.jwt.JwtContextUtils;
import com.cloud.webapi.context.jwt.JwtUser;
import com.cloud.webapi.context.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-12-18 11:11
 **/
@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private JwtContextUtils jwtContextUtils;

    @Resource
    private OperatorClient userClient;

    @Override
    public void addOperator(OperatorAddDto userAddDto) {
        userClient.addOperator(userAddDto);
    }

    @Override
    public void updateOperator(OperatorEditDto userDto) {
        userClient.updateOperator(userDto);
    }

    @Override
    public void certificationOperator(CertificationDto certificationDto) {
        userClient.certificationOperator(certificationDto);
    }

    @Override
    public OperatorInfoDto getOperatorInfo(String openId) {
        return  userClient.getOperatorInfo(openId);
    }

    @Override
    public PageResult<OperatorInfoDto> getOperatorList(int pageIndex, int pageSize) {
        return  userClient.getOperatorList(pageIndex,pageSize);
    }

    @Override
    public Map<String,Object> login(LoginDto loginDto) {
        OperatorInfoDto login = userClient.login(loginDto);
        JwtUser jwtUser = new JwtUser();
        jwtUser.setId(login.getOpenId());
        String token = jwtContextUtils.create(jwtUser);
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        return map;
    }

    @Override
    public Boolean checkedPhone(String phone) {
        return  userClient.checkedPhone(phone);
    }
}
