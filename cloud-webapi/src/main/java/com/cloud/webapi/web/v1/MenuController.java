package com.cloud.webapi.web.v1;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.MenuClient;
import com.cloud.ccb.api.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-12-17 15:46
 **/
@RestController
public class MenuController {

    @Autowired
    private MenuClient menuClient;


    @GetMapping("/menu")
    public PageResult<MenuDto> getPageList(@RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "isLeaf", required = false) Boolean isLeaf,
                                    @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        return menuClient.getPageList(name,isLeaf,pageIndex,pageSize);
    };

    @GetMapping("/menu/{id}")
    public MenuDto getMenu(@PathVariable("id") String id){
        return menuClient.getMenu(id);
    };

    @PostMapping("/menu")
    public void addMenu(@RequestBody MenuDto menuDto){
        menuClient.addMenu(menuDto);
    };

    @PutMapping("/menu")
    public void editMenu(@RequestBody MenuDto menuDto){
        menuClient.editMenu(menuDto);
    };

    @DeleteMapping("/menu")
    public void delete(@RequestParam("id") String id){
        menuClient.delete(id);
    };


}
