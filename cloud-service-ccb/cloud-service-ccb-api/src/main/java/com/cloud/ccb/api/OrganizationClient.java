package com.cloud.ccb.api;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-11-15 11:30
 **/
@FeignClient(name = "cloud-service-ccb-context",configuration = FeignConfiguration.class)
public interface OrganizationClient {

    @GetMapping("/organization/find")
    OrganizationDto find(@RequestParam("id") String id);

    @GetMapping("/organization/getPageList")
    PageResult<OrganizationDto> getPageList(
            @RequestParam(value = "name",required = false)String name ,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize);

    @PostMapping("/organization/add")
    String add( @RequestBody OrganizationDto organization);

    @PostMapping("/organization/update")
    String update( @RequestBody OrganizationDto organization);

}
