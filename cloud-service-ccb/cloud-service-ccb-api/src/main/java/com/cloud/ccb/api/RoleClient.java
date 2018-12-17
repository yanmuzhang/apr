package com.cloud.ccb.api;


import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.RoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cloud-service-ccb-context",configuration = FeignConfiguration.class)
public interface RoleClient {

    @GetMapping("/role/{id}")
    RoleDto getRole(@PathVariable("id") String id);

    @PostMapping("/role")
    void addRole(@RequestBody RoleDto roleDto);

    @PutMapping("/role")
    void editRole(@RequestBody RoleDto roleDto);

    @GetMapping("/role")
    PageResult<RoleDto> getPageList(@RequestParam(value = "name",required = false,defaultValue = "") String name,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize);

    @DeleteMapping("/role/{id}")
    void delete(@PathVariable("id") String id);
}
