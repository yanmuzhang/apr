package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:52
 **/
@Getter
@Setter
@NoArgsConstructor
public class MenuDto {
    private String  id;
    private String  name;
    private String  url;
    private String  icon;
    private Boolean isVisible;
    private Boolean isLeaf;
    private String  menuNo;
    private String  moduleId;
    private String  parentId;
    private Integer orderList;
    private Set<ButtonDto> buttonSet;
}
