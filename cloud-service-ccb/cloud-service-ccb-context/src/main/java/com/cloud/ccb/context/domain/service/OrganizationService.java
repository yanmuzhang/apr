package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.model.Organization;

public interface OrganizationService {

    OrganizationDto find(String id);

    PageResult<OrganizationDto> getPageList(String name ,Integer pageIndex,Integer pageSize);

    String add( OrganizationDto organization);

    String update(OrganizationDto organization);
}
