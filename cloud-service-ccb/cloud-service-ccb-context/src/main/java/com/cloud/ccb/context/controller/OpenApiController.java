package com.cloud.ccb.context.controller;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OpenApiClient;
import com.cloud.ccb.api.dto.*;
import com.cloud.ccb.context.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-11-15 11:31
 **/
@RestController
public class OpenApiController extends BaseController implements OpenApiClient {


    @Autowired
    private OperatorService userService;

    @Override
    public void addOperator(@RequestBody OperatorAddDto userAddDto) {
        userService.addOperator(userAddDto);
    }

    @Override
    public void updateOperator(@RequestBody OperatorEditDto userDto) {
        userService.updateOperator(userDto);
    }

    @Override
    public void certificationOperator(@RequestBody  CertificationDto certificationDto) {
        userService.certificationOperator(certificationDto);
    }

    @Override
    public OperatorInfoDto getOperatorInfo(@RequestParam("openId") String openId) {
        return userService.getOperatorInfo(openId);
    }

    @Override
    public PageResult<OperatorInfoDto> getOperatorList(
                                                       @RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex,
                                                       @RequestParam(name = "pageSize",defaultValue = "10") int pageSize) {
        return userService.getOperatorList(pageIndex,pageSize);
    }

    @Override
    public OperatorInfoDto login(@RequestBody LoginDto loginDto) {
        loginDto.setAppId(getAppId());
        return userService.login(loginDto);
    }

    @Override
    public Boolean checkedPhone(@RequestParam("phone") String phone) {
        return userService.checkedPhone(phone);
    }
}
