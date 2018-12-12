package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.RepositoryLink;
import com.cloud.ccb.context.domain.repository.OrganizationRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: zhangchao
 * @time: 2018-11-14 16:27
 **/
@Getter
@NoArgsConstructor
@RepositoryLink(OrganizationRepository.class)
public class Organization extends EntityObject<String> {
    private static final long serialVersionUID = 8147610701092383680L;
    public enum OrganizationType {
        SE, PE, SOE, FIE
    }
    public enum LicenseType {
        THREE_IN_ONE,
        NORMAL
    }
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


    public void init(String name, OrganizationType organizationType, String registerNumber, String zipCode, String address, String organizationCode, String businessScope, String businessLicense, LicenseType licenseType, String legalPersonName, String legalPersonIdNumber, String legalPersonIdFront, String legalPersonIdBack) {
        this.name = name;
        this.organizationType = organizationType;
        this.registerNumber = registerNumber;
        this.zipCode = zipCode;
        this.address = address;
        this.organizationCode = organizationCode;
        this.businessScope = businessScope;
        this.businessLicense = businessLicense;
        this.licenseType = licenseType;
        this.legalPersonName = legalPersonName;
        this.legalPersonIdNumber = legalPersonIdNumber;
        this.legalPersonIdFront = legalPersonIdFront;
        this.legalPersonIdBack = legalPersonIdBack;
    }
}
