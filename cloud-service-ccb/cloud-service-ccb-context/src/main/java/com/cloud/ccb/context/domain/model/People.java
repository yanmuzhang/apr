package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import com.cloud.ccb.context.domain.repository.PeopleRepostory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * People
 * @author: zhangchao
 * @time: 2018-11-15 09:46
 **/
@Getter
@NoArgsConstructor
@RepositoryLink(PeopleRepostory.class)
public class People extends EntityObject<String> {
    private static final long serialVersionUID = 1367371057585972378L;
    private String phone;
    private Set<LoginInfo> loginInfos = new HashSet<>();
    private CertificationInfo certificationInfo;
    private List<BindingPhoneHistory> phoneHistoryList = new ArrayList<>();

    /**
     * 初始化
     * @param phone
     */
    public void init(String phone,Set<LoginInfo> loginInfos,CertificationInfo certificationInfo,List<BindingPhoneHistory> phoneHistoryList) {
        this.phone = phone;
        this.loginInfos = loginInfos;
        this.certificationInfo = certificationInfo;
        this.phoneHistoryList = phoneHistoryList;
    }

    /**
     * 实名认证
     * @param certificationInfo
     */
    public void certification(CertificationInfo certificationInfo){
        this.certificationInfo = certificationInfo;
    }

    public void bindPhone(String phone){
        this.phone = phone;
        BindingPhoneHistory build = new BindingPhoneHistory();
        build.init(getId(),this.phone,BindingPhoneHistory.BindingType.BINDING,LocalDateTime.now());
        if(phoneHistoryList == null){
            this.phoneHistoryList = new ArrayList<>();
        }
        this.phoneHistoryList.add(build);
        loginInfos.stream().filter(i->i.getSource()==LoginInfo.Source.PHONE).forEach(i->i.setMark(phone));
    }

    public void unBindPhone(){
        this.phone = null;
        BindingPhoneHistory build = new BindingPhoneHistory();
        build.init(getId(),this.phone,BindingPhoneHistory.BindingType.UNBINDING,LocalDateTime.now());
        if(phoneHistoryList == null){
            this.phoneHistoryList = new ArrayList<>();
        }
        this.phoneHistoryList.add(build);

        loginInfos.stream().filter(i->i.getSource()==LoginInfo.Source.PHONE).forEach(i->i.setMark(null));

    }

}
