package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.MenuDto;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:51
 **/
public interface MenuService {

    void addMenu(MenuDto menuDto);

    void editMenu(MenuDto menuDto);

    MenuDto getMenu(String id);

    PageResult<MenuDto> getPageList(String name,Boolean isLeaf,Integer pageIndex,Integer pageSize);

    void delete(String id);

}
