package com.cloud.system.context.repository.model;

import com.cloud.ddd.repository.EntityObject;
import com.cloud.ddd.repository.RepositoryLink;
import com.cloud.system.context.repository.AdminRepository;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-08-22 15:06
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RepositoryLink(AdminRepository.class)
public class Admin extends EntityObject<String>  {
    private static final long serialVersionUID = 9061469338393242972L;
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
    private Set<Group> groupSet = new HashSet<Group>();

}
