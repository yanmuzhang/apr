package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: zhangchao
 * @time: 2018-11-15 14:32
 **/
@Getter
@Setter
@NoArgsConstructor
public class CertificationDto  {
    private String appId;
    private String openId;
    private String idCardNumber;
    private String name;
    private String cardFront;
    private String cardBack;
}
