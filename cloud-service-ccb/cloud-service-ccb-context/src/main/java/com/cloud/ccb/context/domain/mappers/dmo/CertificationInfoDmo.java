package com.cloud.ccb.context.domain.mappers.dmo;

public class CertificationInfoDmo {
    private String idCardNumber;

    private String name;

    private String cardFront;

    private String cardBack;

    private String peopleId;

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber == null ? null : idCardNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardFront() {
        return cardFront;
    }

    public void setCardFront(String cardFront) {
        this.cardFront = cardFront == null ? null : cardFront.trim();
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardBack(String cardBack) {
        this.cardBack = cardBack == null ? null : cardBack.trim();
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId == null ? null : peopleId.trim();
    }
}