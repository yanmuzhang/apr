package com.cloud.ccb.context.domain.service.impl;

import cn.liberfree.common.Page;
import cn.liberfree.common.PageResult;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.mybatis.PageParames;
import com.cloud.ccb.api.dto.OperatorInfoDto;
import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.model.Organization;
import com.cloud.ccb.context.domain.query.OrganizationQuery;
import com.cloud.ccb.context.domain.service.OrganizationService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-14 16:35
 **/
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    EntityLoader entityLoader;

    @Autowired
    OrganizationQuery organizationQuery;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public PageResult<OrganizationDto> getPageList(String name ,Integer pageIndex, Integer pageSize) {
        Page<String> page = organizationQuery.list(name, PageParames.create(pageIndex, pageSize));
        List<OrganizationDto> collect = page.getRows().stream().map(id -> find(id)).collect(Collectors.toList());

        Page<OrganizationDto>  pageList = new Page<>();
        pageList.setPageIndex(pageIndex);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(page.getTotalCount());
        pageList.setRows(collect);
        return PageResult.build(pageList);
    }

    @Override
    public OrganizationDto find(String id) {
        Organization organization = entityLoader.load(id, Organization.class);
        return mapper.map(organization,OrganizationDto.class);
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

    @Override
    public String update(OrganizationDto organizationDto) {
        Organization organization = entityLoader.load(organizationDto.getId(),Organization.class);
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
        return id;
    }
}
