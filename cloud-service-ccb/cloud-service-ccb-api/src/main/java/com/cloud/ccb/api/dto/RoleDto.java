package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:24
 **/
@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private String id;
    private String name;
    private String description;
    private Set<String> menus;
}
