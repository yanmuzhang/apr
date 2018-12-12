package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.ValueObject;
import lombok.*;

import java.time.LocalDateTime;

/**
 * BindingPhoneHistory
 * @author: zhangchao
 * @time: 2018-11-15 09:46
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BindingPhoneHistory extends ValueObject {
    private static final long serialVersionUID = 1367371057585972378L;
    private String peopleId;
    private String phone;
    private BindingType bindingType;
    private LocalDateTime createTime;


    enum BindingType{
        BINDING,
        UNBINDING
    }

    public void init(String peopleId,String phone, BindingType bindingType, LocalDateTime createTime) {
        this.peopleId = peopleId;
        this.phone = phone;
        this.bindingType = bindingType;
        this.createTime = createTime;
    }
}
