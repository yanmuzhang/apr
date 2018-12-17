package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import com.cloud.ccb.context.domain.repository.MenuRepostory;
import com.cloud.ccb.context.domain.repository.RoleRepostory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-20 15:45
 **/
@Getter
@NoArgsConstructor
@RepositoryLink(MenuRepostory.class)
public class Menu extends EntityObject<String> {
    private static final long serialVersionUID = -7388584572807707611L;
    private String  name;
    private String  url;
    private String  icon;
    private Boolean isVisible;
    private Boolean isLeaf;
    private String  menuNo;
    private String  moduleId;
    private String  parentId;
    private Integer orderList;
    private Set<Button> buttonSet;


    public void init(String name, String url, String icon, Boolean visible, String menuNo, String moduleId, String parentId, Integer orderList, Set<Button> buttonSet) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.isVisible = visible;
        this.isLeaf = !StringUtils.isEmpty(parentId);
        this.menuNo = menuNo;
        this.moduleId = moduleId;
        this.parentId = parentId;
        this.orderList = orderList;
        this.buttonSet = buttonSet;
    }

    public void edit(String name, String url, String icon, Boolean visible,String menuNo, String moduleId, String parentId, Integer orderList, Set<Button> buttonSet) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.isVisible = visible;
        this.isLeaf  = !StringUtils.isEmpty(parentId);
        this.menuNo = menuNo;
        this.moduleId = moduleId;
        this.parentId = parentId;
        this.orderList = orderList;
        this.buttonSet = buttonSet;
    }


    public void updateButton(Set<Button> buttonSet){
        this.buttonSet = buttonSet;
    }
}
