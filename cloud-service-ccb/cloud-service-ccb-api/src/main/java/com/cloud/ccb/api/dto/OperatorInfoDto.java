package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-15 11:17
 **/
@Getter
@Setter
@NoArgsConstructor
public class OperatorInfoDto implements Serializable {
    private static final long serialVersionUID = -1181880286934907639L;

    private String openId;
    private String phone;
    private CertificationInfoDto certificationInfo;
    private Map<String,String> attrs;
    private Set<RoleDto> roles;
}