package com.cloud.ccb.api.dto;

import lombok.*;

/**
 * @author: zhangchao
 * @time: 2018-08-20 16:34
 **/
@Setter
@Getter
@NoArgsConstructor
public class LoginDto{
    private String appId;
    private String phone;
    private Source source;
    private String password;

    public enum Source{PASSWORD,PHONE}
}
