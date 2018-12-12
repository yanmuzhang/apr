package com.cloud.ccb.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-11-15 15:21
 **/
@Getter
@Setter
@NoArgsConstructor
public class OrganizationDto implements Serializable {
    private static final long serialVersionUID = -8332587459196432717L;

    public enum OrganizationType {
        SE, PE, SOE, FIE
    }
    public enum LicenseType {
        THREE_IN_ONE,
        NORMAL
    }
    private String id;
    private String name;
    private OrganizationType organizationType;
    private String registerNumber;
    private String zipCode;
    private String address;
    private String organizationCode;
    private String businessScope;
    private String businessLicense;
    private LicenseType licenseType;
    private String legalPersonName;
    private String legalPersonIdNumber;
    private String legalPersonIdFront;
    private String legalPersonIdBack;
}
