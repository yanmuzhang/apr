package com.cloud.ccb.context.controller;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OrganizationClient;
import com.cloud.ccb.api.dto.OrganizationDto;
import com.cloud.ccb.context.domain.model.Organization;
import com.cloud.ccb.context.domain.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-11-13 12:29
 **/
@RestController
public class OrgController implements OrganizationClient {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public OrganizationDto find(@RequestParam("id") String id){
        return organizationService.find(id);
    }

    @Override
    public PageResult<OrganizationDto> getPageList( @RequestParam(value = "name",required = false)String name ,
                                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize) {
        return organizationService.getPageList(name,pageIndex,pageSize);
    }

    @Override
    public String add(@RequestBody OrganizationDto organization) {
        return organizationService.add(organization);
    }

    @Override
    public String update(@RequestBody OrganizationDto organization) {
        return organizationService.update(organization);
    }
}
