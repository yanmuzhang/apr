package com.cloud.ccb.context.controller;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OperatorClient;
import com.cloud.ccb.api.dto.*;
import com.cloud.ccb.context.domain.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangchao
 * @time: 2018-11-15 11:31
 **/
@RestController
public class OperatorController extends BaseController implements OperatorClient {


    @Autowired
    private OperatorService operatorService;

    @Override
    public void addOperator(@RequestBody OperatorAddDto userAddDto) {
        operatorService.addOperator(userAddDto);
    }

    @Override
    public void updateOperator(@RequestBody OperatorEditDto userDto) {
        operatorService.updateOperator(userDto);
    }

    @Override
    public void certificationOperator(@RequestBody  CertificationDto certificationDto) {
        operatorService.certificationOperator(certificationDto);
    }

    @Override
    public OperatorInfoDto getOperatorInfo(@RequestParam("openId") String openId) {
        return operatorService.getOperatorInfo(openId);
    }

    @Override
    public PageResult<OperatorInfoDto> getOperatorList(
                                                       @RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex,
                                                       @RequestParam(name = "pageSize",defaultValue = "10") int pageSize) {
        return operatorService.getOperatorList(pageIndex,pageSize);
    }

    @Override
    public OperatorInfoDto login(@RequestBody LoginDto loginDto) {
        loginDto.setAppId(getAppId());
        return operatorService.login(loginDto);
    }

    @Override
    public Boolean checkedPhone(@RequestParam("phone") String phone) {
        return operatorService.checkedPhone(phone);
    }
}
