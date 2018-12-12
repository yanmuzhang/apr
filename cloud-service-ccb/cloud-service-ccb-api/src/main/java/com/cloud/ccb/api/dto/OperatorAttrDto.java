package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-11-15 14:08
 **/
@Getter
@Setter
public class OperatorAttrDto implements Serializable {
    private static final long serialVersionUID = 6225789554088213552L;
    private String name;
    private String value;
    private Integer sort;

}
