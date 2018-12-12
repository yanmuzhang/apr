package com.cloud.system.api.dto;

import com.cloud.ddd.repository.EntityObject;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author: zhangchao
 * @time: 2018-08-21 15:09
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDto extends EntityObject<String> {

    private Date createTime;

    private Date updateTime;

    private String username;

    private String password;

    private String passwordSalt;

    private String nickname;

    private String sex;

    private Short age;

    private String icon;

    private String name;

    private String status;

    private String phone;

    private Date lastLoginDate;

    private String lastLoginIp;

    private String loginCount;

    private Date registerDate;

    private String registerIp;

}
