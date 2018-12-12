package com.cloud.user.context.repository;

import com.cloud.ddd.repository.EntityObject;
import com.cloud.ddd.repository.RepositoryLink;
import com.cloud.user.context.repository.model.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhangchao
 * @time: 2018-07-30 17:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RepositoryLink(UserRepository.class)
public class User extends EntityObject<String> implements Serializable {
    private static final long serialVersionUID = -2386788102145257672L;

    private Date createTime;
    private Date updateTime;
    private String nickname;
    private String name;
    private Integer age;
    private String password;
    private String icon;
    private Status status;
    private Sex sex;
    private String phone;
    private Date lastLoginDate;
    private String lastLoginIp;
    private Integer loginCount;
    private String registerIp;
    private String email;


    public enum Status { ENABLE, DISABLE }

    public enum Sex { MAN, WOMAN }

}
