package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.JsonUtils;
import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.model.Organization;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrganizationServiceTest extends BaseServiceTest{

    @Autowired
    private OrganizationService organizationService;

    @Test
    public void find() {
        System.out.println(JsonUtils.convertObjectToJSON(organizationService.find("0FCB15E5BAE74781A8EDCD3F4F750AD4")));
    }

    @Test
    public void add() {

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setName("成都火柴科技有限公司");
        organizationDto.setAddress("中环路锦绣大道1111号");
        organizationDto.setZipCode("618000");
        organizationDto.setLicenseType(OrganizationDto.LicenseType.NORMAL);
        organizationDto.setOrganizationCode("");
        organizationDto.setOrganizationType(OrganizationDto.OrganizationType.PE);
        organizationDto.setRegisterNumber("");
        organizationDto.setBusinessLicense("");
        organizationDto.setBusinessScope("");
        organizationDto.setLegalPersonIdBack("");
        organizationDto.setLegalPersonIdFront("");
        organizationDto.setLegalPersonIdNumber("");
        organizationDto.setLegalPersonName("");
        System.out.println(organizationService.add(organizationDto));
    }
}