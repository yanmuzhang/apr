package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import cn.liberfree.de.repository.ValueObject;
import com.cloud.ccb.context.domain.repository.MenuRepostory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-20 15:45
 **/
@Getter
@Setter
@NoArgsConstructor
@RepositoryLink(MenuRepostory.class)
public class Button extends ValueObject {
    private static final long serialVersionUID = -7388584572807707611L;
    private String menuId;
    private String  btnNo;
    private String  btnName;
    private String  btnType;
    private String btnIcon;
    private Boolean  initStatus;
}
