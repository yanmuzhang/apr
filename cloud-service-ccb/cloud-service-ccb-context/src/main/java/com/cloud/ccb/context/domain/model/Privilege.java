package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.ValueObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 权限管理器
 * @author: zhangchao
 * @time: 2018-11-20 17:15
 **/
@Getter
@Setter
@NoArgsConstructor
public class Privilege extends ValueObject{
    private static final long serialVersionUID = -9068076346070100385L;


    private MasterType masterType;
    private String maserId;
    private AccessType accessType;
    private String accessId;
    private String isOperatation;
    private String appId;



    public enum MasterType{
        /**
         * 角色
         */
        ROLE,
        /**
         * 用户
         */
        USER
    }
    public enum AccessType{
        /**
         * 菜单
         */
        MENU,
        /**
         * 按钮
         */
        BUTTON,
        /**
         * 模块
         */
        MODULE
    }
}
