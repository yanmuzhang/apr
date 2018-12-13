package com.cloud.webapi.web.v1;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.OrganizationClient;
import com.cloud.ccb.api.dto.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-12-13 14:19
 **/
@RestController
@RequestMapping("/organization")
public class OrganizationController  {

    @Autowired
    OrganizationClient organizationClient;


    @GetMapping("/find")
    public OrganizationDto find(@RequestParam("id") String id){
        return organizationClient.find(id);
    }

    @GetMapping("/getPageList")
    public PageResult<OrganizationDto> getPageList(
            @RequestParam(value = "name",required = false)String name ,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize){
        return organizationClient.getPageList(name,pageIndex,pageSize);
    }

    @PostMapping("/add")
    public String add( @RequestBody OrganizationDto organization){
        return organizationClient.add(organization);
    }

    @PostMapping("/update")
    public String update( @RequestBody OrganizationDto organization){
        return organizationClient.update(organization);
    }

}
