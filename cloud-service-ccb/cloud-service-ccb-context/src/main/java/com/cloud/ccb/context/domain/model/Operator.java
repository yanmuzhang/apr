package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import com.cloud.ccb.context.domain.repository.OperatorRepostory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhangchao
 * @time: 2018-11-15 09:46
 **/
@Getter
@NoArgsConstructor
@RepositoryLink(OperatorRepostory.class)
public class Operator extends EntityObject<String> {
    private static final long serialVersionUID = 1367371057585972378L;
    private String peopleId;
    private String  appId;
    private Set<OperatorAttr> attrSet;
    private Set<String> roles;


    public void init(String peopleId,String appId, Set<OperatorAttr> attrSet,Set<String> roles) {
        this.peopleId = peopleId;
        this.appId = appId;
        this.attrSet = attrSet;
        this.roles = roles;
    }


    public void editAttr(Set<OperatorAttr> attrSet){
        this.attrSet = attrSet;
    }

    public void editRoles(Set<String> roles){
        this.roles = roles;
    }



    public Map<String,String> getAttrs(){
        Map<String,String> attr = new HashMap<>();
        if(this.attrSet != null){
            this.attrSet.stream().forEach(item -> attr.put(item.getName(),item.getValue()));
        }
        return attr;
    }





}
