package com.cloud.system.context.repository.model;

import com.cloud.ddd.repository.EntityObject;
import lombok.Data;

import java.util.Date;

/**
 * @author: zhangchao
 * @time: 2018-08-22 15:06
 **/
@Data
public class AdminLogin extends EntityObject<String> {
    private static final long serialVersionUID = 9061469338393242972L;
    private Date createTime;

    private Date updateTime;

    private String adminId;

    private String loginIp;

    private String ip;

    private String os;

    private String browser;

}
