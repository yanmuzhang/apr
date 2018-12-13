package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.*;

/**
 * @author: zhangchao
 * @time: 2018-11-15 14:43
 **/

public interface OperatorService {


    void addOperator(OperatorAddDto userAddDto);

    void updateOperator(OperatorEditDto userDto);

    void certificationOperator(CertificationDto certificationDto);

    OperatorInfoDto getOperatorInfo(String openId);

    PageResult<OperatorInfoDto> getOperatorList(int pageIndex, int pageSize);

    OperatorInfoDto login(LoginDto loginDto);

    Boolean checkedPhone(String phone);
}
