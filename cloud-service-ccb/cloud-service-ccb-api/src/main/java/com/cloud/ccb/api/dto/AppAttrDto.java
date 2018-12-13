package com.cloud.ccb.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: zhangchao
 * @time: 2018-12-13 15:21
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppAttrDto {

    private String name;
    private Boolean required;
    private String defaultValue;
    private Integer sort;
    private String type;

}
