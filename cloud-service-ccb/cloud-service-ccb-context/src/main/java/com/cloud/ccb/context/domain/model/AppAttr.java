package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.ValueObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: zhangchao
 * @time: 2018-11-14 10:18
 **/
@Getter
@Setter
@NoArgsConstructor
public class AppAttr extends ValueObject {
    private static final long serialVersionUID = 6779252666316833666L;
    private String appId;
    private String name;
    private Boolean required;
    private String defaultValue;
    private Integer sort;
    private String type;


    public AppAttr init(String appId, String name,String type, Boolean required, String defaultValue, Integer sort) {
        this.appId = appId;
        this.name = name;
        this.type = type;
        this.required = required;
        this.defaultValue = defaultValue;
        this.sort = sort;
        return this;
    }
}
