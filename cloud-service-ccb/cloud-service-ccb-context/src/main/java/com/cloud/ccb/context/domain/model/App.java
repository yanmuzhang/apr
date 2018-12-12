package com.cloud.ccb.context.domain.model;

import cn.liberfree.common.IdentifyUtils;
import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import com.cloud.ccb.context.domain.repository.AppRepository;
import lombok.Getter;

import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-13 11:17
 **/
@Getter
@RepositoryLink(AppRepository.class)
public class App extends EntityObject<String> {

    private static final long serialVersionUID = -5370161274378136103L;

    private String secret;

    private String name;

    private String organizationId;

    private Set<AppAttr> appAttrs;

    public void init(String name,String organizationId,Set<AppAttr> appAttrs){
        this.name = name;
        this.secret = IdentifyUtils.uuid();;
        this.organizationId = organizationId;
        this.appAttrs = appAttrs;
    }


    /**
     * 刷新 secret
     */
    public void refreshSecret(){
        this.secret = IdentifyUtils.uuid();
    }


    /**
     * 编辑属性
     * @param appAttrs
     */
    public void editAttr(Set<AppAttr> appAttrs){
        this.appAttrs = appAttrs;
    }

}
