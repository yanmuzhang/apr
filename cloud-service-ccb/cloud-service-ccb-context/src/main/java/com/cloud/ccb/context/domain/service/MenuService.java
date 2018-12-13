package com.cloud.ccb.context.domain.service;

import com.cloud.ccb.api.dto.MenuDto;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:51
 **/
public interface MenuService {

    void addMenu(MenuDto menuDto);

    void editMenu(MenuDto menuDto);

    MenuDto getMenu(String id);

}
