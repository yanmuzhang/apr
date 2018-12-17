package com.cloud.ccb.context.controller;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.MenuClient;
import com.cloud.ccb.api.dto.MenuDto;
import com.cloud.ccb.context.domain.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-12-17 15:37
 **/
@RestController
public class MenuController extends BaseController implements MenuClient {

    @Autowired
    private MenuService menuService;

    public PageResult<MenuDto> getPageList(@RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "isLeaf", required = false) Boolean isLeaf,
                                           @RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex,
                                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return menuService.getPageList(name,isLeaf,pageIndex,pageSize);
    }

    public MenuDto getMenu(@PathVariable("id") String id){
        return menuService.getMenu(id);
    };

    public void addMenu(@RequestBody MenuDto menuDto){
        menuService.addMenu(menuDto);
    };

    public void editMenu(@RequestBody MenuDto menuDto){
        menuService.editMenu(menuDto);
    };

    public void delete(@RequestParam("id") String id){
        menuService.delete(id);
    };
}
