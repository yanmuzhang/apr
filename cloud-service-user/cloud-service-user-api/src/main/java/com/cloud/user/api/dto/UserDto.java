package com.cloud.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: zhangchao
 * @time: 2018-08-03 10:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;

    private Date createTime;

    private Date updateTime;

    private String nickname;

    private String name;

    private Integer age;

    private String password;

    private String icon;

    private String status;

    private String sex;

    private String phone;

    private Date lastLoginDate;

    private String lastLoginIp;

    private Integer loginCount;

    private String registerIp;

    private String email;
}
