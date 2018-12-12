package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhangchao
 * @time: 2018-11-15 14:10
 **/
@Getter
@Setter
public class CertificationInfoDto {
    private String idCardNumber;
    private String name;
    private String cardFront;
    private String cardBack;
}
