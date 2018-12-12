package com.cloud.ccb.context.service.impl;

import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.EntityObject;
import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.model.Organization;
import com.cloud.ccb.context.service.OrganizationService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhangchao
 * @time: 2018-11-14 16:35
 **/
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    EntityLoader entityLoader;


    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Organization find(String id) {
        Organization organization = entityLoader.load(id, Organization.class);
        return organization;
    }

    @Override
    public String add(OrganizationDto organizationDto) {
        Organization organization = entityLoader.create(Organization.class);
        organization.init(
                organizationDto.getName(),
                organizationDto.getOrganizationType()==null?null:Organization.OrganizationType.valueOf(organizationDto.getOrganizationType().name()),
                organizationDto.getRegisterNumber(),
                organizationDto.getZipCode(),
                organizationDto.getAddress(),
                organizationDto.getOrganizationCode(),
                organizationDto.getBusinessScope(),
                organizationDto.getBusinessLicense(),
                organizationDto.getLicenseType()==null?null:Organization.LicenseType.valueOf(organizationDto.getLicenseType().name()),
                organizationDto.getLegalPersonName(),
                organizationDto.getLegalPersonIdNumber(),
                organizationDto.getLegalPersonIdFront(),
                organizationDto.getLegalPersonIdBack());
        String id = organization.getId();
        mapper.map(organizationDto,organization);
        organization.setId(id);
        return organization.getId();
    }
}
