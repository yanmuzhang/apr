package com.cloud.system.context.repository.model;

import com.cloud.ddd.repository.EntityObject;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-08-22 15:06
 **/
@Data
public class Group extends EntityObject<String> {
    private static final long serialVersionUID = 9061469338393242972L;
    private Date createTime;

    private Date updateTime;

    private String name;

    public Set<Role> roleSet = new HashSet<Role>();

}
