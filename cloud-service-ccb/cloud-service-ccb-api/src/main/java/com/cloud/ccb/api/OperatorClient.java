package com.cloud.ccb.api;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-11-15 11:30
 **/
@FeignClient(name = "cloud-service-ccb-context",configuration = FeignConfiguration.class)
public interface OperatorClient {

    /**
     * 添加用户
     * @param userAddDto
     */
    @PostMapping(value = "/operator/addOperator")
    void addOperator(@RequestBody OperatorAddDto userAddDto);

    /**
     * 修改用户
     * @param userDto
     */
    @PostMapping(value = "/operator/updateOperator")
    void updateOperator(@RequestBody OperatorEditDto userDto);

    /**
     * 实名认证
     * @param certificationDto
     */
    @PostMapping(value = "/operator/certificationOperator")
    void certificationOperator(@RequestBody CertificationDto certificationDto);


    /**
     * 用户信息
     * @param openId
     * @return
     */
    @GetMapping(value = "/operator/getOperatorInfo")
    OperatorInfoDto getOperatorInfo(@RequestParam("openId") String openId);


    /**
     * 用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/operator/getOperatorList")
    PageResult<OperatorInfoDto> getOperatorList(
                                                @RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex,
                                                @RequestParam(name = "pageSize",defaultValue = "10") int pageSize);


    /**
     * 登录
     * @param loginDto
     * @return
     */
    @PostMapping(value = "/operator/login")
    OperatorInfoDto login(@RequestBody LoginDto loginDto);

    /**
     * 校验用户是否存在
     * @param phone
     * @return
     */
    @GetMapping(value = "/operator/checkedPhone")
    Boolean checkedPhone(@RequestParam("phone") String phone);





}
