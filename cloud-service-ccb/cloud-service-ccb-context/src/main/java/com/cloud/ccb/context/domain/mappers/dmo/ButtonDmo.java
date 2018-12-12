package com.cloud.ccb.context.domain.mappers.dmo;

public class ButtonDmo {
    private String btnNo;

    private String btnName;

    private String btnType;

    private String btnIcon;

    private String menuId;

    private Boolean initStatus;

    public String getBtnNo() {
        return btnNo;
    }

    public void setBtnNo(String btnNo) {
        this.btnNo = btnNo == null ? null : btnNo.trim();
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName == null ? null : btnName.trim();
    }

    public String getBtnType() {
        return btnType;
    }

    public void setBtnType(String btnType) {
        this.btnType = btnType == null ? null : btnType.trim();
    }

    public String getBtnIcon() {
        return btnIcon;
    }

    public void setBtnIcon(String btnIcon) {
        this.btnIcon = btnIcon == null ? null : btnIcon.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public Boolean getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Boolean initStatus) {
        this.initStatus = initStatus;
    }
}