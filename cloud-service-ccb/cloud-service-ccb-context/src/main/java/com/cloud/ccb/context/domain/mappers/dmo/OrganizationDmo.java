package com.cloud.ccb.context.domain.mappers.dmo;

public class OrganizationDmo {
    private String id;

    private String name;

    private String organizationType;

    private String registerNumber;

    private String zipCode;

    private String address;

    private String organizationCode;

    private String businessScope;

    private String businessLicense;

    private String licenseType;

    private String legalPersonName;

    private String legalPersonIdNumber;

    private String legalPersonIdFront;

    private String legalPersonIdBack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType == null ? null : organizationType.trim();
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber == null ? null : registerNumber.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType == null ? null : licenseType.trim();
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
    }

    public String getLegalPersonIdNumber() {
        return legalPersonIdNumber;
    }

    public void setLegalPersonIdNumber(String legalPersonIdNumber) {
        this.legalPersonIdNumber = legalPersonIdNumber == null ? null : legalPersonIdNumber.trim();
    }

    public String getLegalPersonIdFront() {
        return legalPersonIdFront;
    }

    public void setLegalPersonIdFront(String legalPersonIdFront) {
        this.legalPersonIdFront = legalPersonIdFront == null ? null : legalPersonIdFront.trim();
    }

    public String getLegalPersonIdBack() {
        return legalPersonIdBack;
    }

    public void setLegalPersonIdBack(String legalPersonIdBack) {
        this.legalPersonIdBack = legalPersonIdBack == null ? null : legalPersonIdBack.trim();
    }
}