package com.cloud.webapi.web.v1;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OperatorClient;
import com.cloud.ccb.api.dto.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:52
 **/
@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Resource
    private OperatorClient userClient;

    /**
     * 添加用户
     * @param userAddDto
     */
    @PostMapping(value = "/addOperator")
    public void addOperator(@RequestBody OperatorAddDto userAddDto){
        userClient.addOperator(userAddDto);
    }

    /**
     * 修改用户
     * @param userDto
     */
    @PostMapping(value = "/updateOperator")
    public void updateOperator(@RequestBody OperatorEditDto userDto){
        userClient.updateOperator(userDto);
    }

    /**
     * 实名认证
     * @param certificationDto
     */
    @PostMapping(value = "/certificationOperator")
    public void certificationOperator(@RequestBody CertificationDto certificationDto){
        userClient.certificationOperator(certificationDto);
    }


    /**
     * 用户信息
     * @param openId
     * @return
     */
    @GetMapping(value = "/getOperatorInfo")
    public OperatorInfoDto getOperatorInfo(@RequestParam(name = "openId") String openId){
       return  userClient.getOperatorInfo(openId);
    }


    /**
     * 用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/getOperatorList")
    public PageResult<OperatorInfoDto> getOperatorList(
                                                @RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex,
                                                @RequestParam(name = "pageSize",defaultValue = "10") int pageSize){
        return userClient.getOperatorList(pageIndex,pageSize);
    }


    /**
     * 登录
     * @param loginDto
     * @return
     */
    @PostMapping(value = "/login")
    public OperatorInfoDto login(@RequestBody LoginDto loginDto){
        return userClient.login(loginDto);
    }

    /**
     * 退出登录
     */
    @GetMapping(value = "/logout")
    public void logout(){
        System.out.println("logout");
    }

    /**
     * 校验用户是否存在
     * @param phone
     * @return
     */
    @GetMapping(value = "/checkedPhone")
    public Boolean checkedPhone(@RequestParam("phone") String phone){
        return userClient.checkedPhone(phone);
    }


}
