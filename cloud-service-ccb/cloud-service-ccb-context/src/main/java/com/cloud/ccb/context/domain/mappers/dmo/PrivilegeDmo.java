package com.cloud.ccb.context.domain.mappers.dmo;

public class PrivilegeDmo {
    private String masterType;

    private String masterId;

    private String accessType;

    private String accessId;

    private Boolean isOperatation;

    private String appId;

    public String getMasterType() {
        return masterType;
    }

    public void setMasterType(String masterType) {
        this.masterType = masterType == null ? null : masterType.trim();
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType == null ? null : accessType.trim();
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId == null ? null : accessId.trim();
    }

    public Boolean getIsOperatation() {
        return isOperatation;
    }

    public void setIsOperatation(Boolean isOperatation) {
        this.isOperatation = isOperatation;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}