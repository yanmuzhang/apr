package com.cloud.webapi.context.service;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.*;

import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-12-18 11:10
 **/
public interface UserService {

    void addOperator(OperatorAddDto userAddDto);

    void updateOperator(OperatorEditDto userDto);

    void certificationOperator(CertificationDto certificationDto);

    OperatorInfoDto getOperatorInfo(String openId);

    PageResult<OperatorInfoDto> getOperatorList(int pageIndex, int pageSize);

    Map<String,Object> login(LoginDto loginDto);

    Boolean checkedPhone(String phone);

}
