package com.cloud.webapi.web.v1;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OperatorClient;
import com.cloud.ccb.api.dto.*;
import com.cloud.webapi.context.auth.Anonymous;
import com.cloud.webapi.context.jwt.AuthManager;
import com.cloud.webapi.context.jwt.JwtUser;
import com.cloud.webapi.context.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-07-27 16:52
 **/
@RestController
@RequestMapping("/operator")
public class OperatorController {



    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param userAddDto
     */
    @PostMapping(value = "/addOperator")
    public void addOperator(@RequestBody OperatorAddDto userAddDto){
        userService.addOperator(userAddDto);
    }

    /**
     * 修改用户
     * @param userDto
     */
    @PostMapping(value = "/updateOperator")
    public void updateOperator(@RequestBody OperatorEditDto userDto){
        userService.updateOperator(userDto);
    }

    /**
     * 实名认证
     * @param certificationDto
     */
    @PostMapping(value = "/certificationOperator")
    public void certificationOperator(@RequestBody CertificationDto certificationDto){
        userService.certificationOperator(certificationDto);
    }


    /**
     * 用户信息
     * @return
     */
    @GetMapping(value = "/getOperatorInfo")
    public OperatorInfoDto getOperatorInfo(){
        JwtUser jwtUser = AuthManager.currentUser();
        return  userService.getOperatorInfo(jwtUser.getId());
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
        return userService.getOperatorList(pageIndex,pageSize);
    }


    /**
     * 登录
     * @param loginDto
     * @return
     */
    @PostMapping(value = "/login")
    @Anonymous
    public Map<String,Object> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    /**
     * 退出登录
     */
    @Anonymous
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
        return userService.checkedPhone(phone);
    }


}
