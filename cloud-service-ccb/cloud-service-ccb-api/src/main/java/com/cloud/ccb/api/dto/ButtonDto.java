package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:53
 **/
@Getter
@Setter
@NoArgsConstructor
public class ButtonDto implements Serializable {
    private static final long serialVersionUID = -1234847815105386870L;
    private String menuId;
    private String btnNo;
    private String btnName;
    private String btnType;
    private String btnIcon;
    private Boolean initStatus;
}
