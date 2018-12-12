package com.cloud.ccb.context.domain.mappers.dmo;

import java.util.Date;

public class BindingPhoneHistoryDmo {
    private String peopleId;

    private String phone;

    private Date createTime;

    private String bindingType;

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId == null ? null : peopleId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType == null ? null : bindingType.trim();
    }
}