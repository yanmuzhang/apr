package com.cloud.ccb.context.domain.resolver;

import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.mappers.dmo.AppAttrDmo;
import com.cloud.ccb.context.domain.mappers.dmo.AppDmo;
import com.cloud.ccb.context.domain.mappers.dmo.OrganizationDmo;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.model.AppAttr;
import com.cloud.ccb.context.domain.model.Organization;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-16 13:53
 **/
@Component
public class OrganizationMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(Organization.class).accessible(true), OrganizationDmo.class)
                .fields("name", "name")
                .fields("organizationType", "organizationType")
                .fields("registerNumber", "registerNumber")
                .fields("zipCode", "zipCode")
                .fields("address", "address")
                .fields("organizationCode", "organizationCode")
                .fields("businessScope", "businessScope")
                .fields("businessLicense", "businessLicense")
                .fields("licenseType", "licenseType")
                .fields("legalPersonName", "legalPersonName")
                .fields("legalPersonIdNumber", "legalPersonIdNumber")
                .fields("legalPersonIdFront", "legalPersonIdFront")
                .fields("legalPersonIdBack", "legalPersonIdBack");

        mapping(type(Organization.class).accessible(true), OrganizationDto.class)
                .fields("name", "name")
                .fields("organizationType", "organizationType")
                .fields("registerNumber", "registerNumber")
                .fields("zipCode", "zipCode")
                .fields("address", "address")
                .fields("organizationCode", "organizationCode")
                .fields("businessScope", "businessScope")
                .fields("businessLicense", "businessLicense")
                .fields("licenseType", "licenseType")
                .fields("legalPersonName", "legalPersonName")
                .fields("legalPersonIdNumber", "legalPersonIdNumber")
                .fields("legalPersonIdFront", "legalPersonIdFront")
                .fields("legalPersonIdBack", "legalPersonIdBack");
    }
}
