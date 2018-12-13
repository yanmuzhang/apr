package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.JsonUtils;
import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * 集成测试
 */
public class OperatorServiceTest extends BaseServiceTest{

    Logger logger  = LoggerFactory.getLogger(OperatorServiceTest.class);

    String appId = "8A6153F233854B5E8CF68C5AFBF6C49D";
    String secret = "71d246d88eda4c20866c8fc6ec67b08d";



    @Autowired
    private OperatorService userService;

    @Test
    public void addUser() {
        for (int i = 202; i > 101; i--) {
            OperatorAddDto user = new OperatorAddDto();
            user.setAppId(appId);
            user.setPhone("13000000"+i);
            Set<OperatorAttrDto> userAttrDtos = new HashSet<>();
            OperatorAttrDto userAttrDto = new OperatorAttrDto();
            userAttrDto.setName("nickName");
            userAttrDto.setSort(1);
            userAttrDto.setValue("Sys"+i);
            userAttrDtos.add(userAttrDto);
            userAttrDtos.add(OperatorAttrDto.builder().name("sex").sort(1).value(i%2==0?"MAN":"WOMAN").build());
            userAttrDtos.add(OperatorAttrDto.builder().name("icon").sort(1).value("https://file.ccuol.cn/%E5%9B%BE%E7%89%87.png").build());
            userAttrDtos.add(OperatorAttrDto.builder().name("age").sort(1).value(String.valueOf(i)).build());

            user.setAttrSet(userAttrDtos);
            userService.addOperator(user);
        }
    }

    @Test
    public void updateUser() {
        OperatorInfoDto operatorInfo = userService.getOperatorInfo("19002FB7B85B4FE58363610F7DF5BDEF");
        OperatorEditDto operatorEditDto = new OperatorEditDto();
        operatorInfo.getAttrs().put("nickName","Juck");
        operatorInfo.getAttrs().put("sex","MAIL");
        operatorInfo.getAttrs().put("icon","https://file.ccuol.cn/%E5%9B%BE%E7%89%87.png");
        operatorInfo.getAttrs().put("age","18");
        operatorEditDto.setRoleIds(new HashSet<>(Arrays.asList("6DDB7028E0DC44129F2BC9C5B9CEF8BD")));
        operatorEditDto.setAttrs(operatorInfo.getAttrs());
        operatorEditDto.setOpenId(operatorInfo.getOpenId());
        userService.updateOperator(operatorEditDto);
    }

    @Test
    public void certificationUser() {

    }

    @Test
    public void getUserInfo() {
        System.out.println(JsonUtils.convertObjectToJSON(userService.getOperatorInfo("19002FB7B85B4FE58363610F7DF5BDEF")));
    }

    @Test
    public void getUserList() {
        PageResult<OperatorInfoDto> page = userService.getOperatorList(1, 2);
        logger.info("{}",JsonUtils.convertObjectToJSON(page));
    }

    @Test
    public void login() {
        LoginDto loginDto = new LoginDto();
        loginDto.setAppId(appId);
        loginDto.setPassword("123456");
        loginDto.setPhone("13800001111");
        loginDto.setSource(LoginDto.Source.PASSWORD);
        logger.info("{}",JsonUtils.convertObjectToJSON(userService.login(loginDto)));
    }

    @Test
    public void checkedPhone() {

    }
}