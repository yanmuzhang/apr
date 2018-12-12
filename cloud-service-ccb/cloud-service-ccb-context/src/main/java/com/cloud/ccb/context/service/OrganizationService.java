package com.cloud.ccb.context.service;

import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.model.Organization;

public interface OrganizationService {


    public Organization find(String id);


    public String add( OrganizationDto organization);

}
