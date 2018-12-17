package com.cloud.ccb.api;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.MenuDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-12-17 15:27
 **/
@FeignClient(name = "cloud-service-ccb-context",configuration = FeignConfiguration.class)
public interface MenuClient {

    @GetMapping("/menu")
    PageResult<MenuDto> getPageList(    @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "isLeaf", required = false) Boolean isLeaf,
                                        @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
                                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize);

    @GetMapping("/menu/{id}")
    MenuDto getMenu(@PathVariable("id") String id);

    @PostMapping("/menu")
    void addMenu(@RequestBody MenuDto menuDto);

    @PutMapping("/menu")
    void editMenu(@RequestBody MenuDto menuDto);

    @DeleteMapping("/menu")
    void delete(@RequestParam("id") String id);

}
