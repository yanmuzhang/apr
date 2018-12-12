package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import com.cloud.ccb.context.domain.repository.RoleRepostory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-20 15:45
 **/
@Getter
@NoArgsConstructor
@RepositoryLink(RoleRepostory.class)
public class Role extends EntityObject<String> {
    private static final long serialVersionUID = -7388584572807707611L;
    private String name;
    private String description;
    private Set<String> menus;

    public void init(String name, String description, Set<String> menus) {
        this.name = name;
        this.description = description;
        this.menus = menus;
    }

    public void edit(String name, String description, Set<String> menus) {
        this.name = name;
        this.description = description;
        this.menus = menus;
    }

}
