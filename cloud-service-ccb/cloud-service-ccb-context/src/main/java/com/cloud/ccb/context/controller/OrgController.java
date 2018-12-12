package com.cloud.ccb.context.controller;

import com.cloud.ccb.context.domain.model.Organization;
import com.cloud.ccb.context.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhangchao
 * @time: 2018-11-13 12:29
 **/
@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public Organization list(String id){
        return organizationService.find(id);
    }


}
