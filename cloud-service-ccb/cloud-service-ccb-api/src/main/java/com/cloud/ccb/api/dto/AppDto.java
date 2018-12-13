package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-12-13 15:19
 **/
@Getter
@Setter
@NoArgsConstructor
public class AppDto  implements Serializable {
    private static final long serialVersionUID = -6494060748177289706L;

    private String id;
    private String name;
    private String secret;
    private String organizationId;
    private Set<AppAttrDto> appAttrs;

}
