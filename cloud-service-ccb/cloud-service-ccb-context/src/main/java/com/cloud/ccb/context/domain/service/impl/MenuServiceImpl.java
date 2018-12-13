package com.cloud.ccb.context.domain.service.impl;

import cn.liberfree.de.loader.EntityLoader;
import com.cloud.ccb.api.dto.ButtonDto;
import com.cloud.ccb.api.dto.MenuDto;
import com.cloud.ccb.context.domain.model.Button;
import com.cloud.ccb.context.domain.model.Menu;
import com.cloud.ccb.context.domain.service.MenuService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:51
 **/
@Service
public class MenuServiceImpl implements MenuService {


    @Autowired
    private EntityLoader entityLoader;

    @Autowired
    private DozerBeanMapper mapper;



    @Override
    public void addMenu(MenuDto menuDto) {
        Menu menu = entityLoader.create(Menu.class);
        Set<ButtonDto> buttonSet = menuDto.getButtonSet();
        Set<Button> collect = null;
        if(buttonSet != null){
            collect = buttonSet.stream().map(item -> mapper.map(item, Button.class)).collect(Collectors.toSet());
        }
        menu.init(menuDto.getName(),menuDto.getUrl(),menuDto.getIcon(),menuDto.getIsVisible(),menuDto.getIsLeaf(),menuDto.getMenuNo(),menuDto.getModuleId(),menuDto.getParentId(),menuDto.getOrderList(),collect);
    }

    @Override
    public void editMenu(MenuDto menuDto) {
        Menu menu = entityLoader.load(menuDto.getId(),Menu.class);
        Set<ButtonDto> buttonSet = menuDto.getButtonSet();
        Set<Button> collect = null;
        if(buttonSet != null){
         collect = buttonSet.stream().map(item -> mapper.map(item, Button.class)).collect(Collectors.toSet());
        }
        menu.edit(menuDto.getName(),menuDto.getUrl(),menuDto.getIcon(),menuDto.getIsVisible(),menuDto.getIsLeaf(),menuDto.getMenuNo(),menuDto.getModuleId(),menuDto.getParentId(),menuDto.getOrderList(),collect);
    }

    @Override
    public MenuDto getMenu(String id) {
        Menu menu = entityLoader.load(id,Menu.class);
        MenuDto map = mapper.map(menu, MenuDto.class);
        Set<Button> buttonSet = menu.getButtonSet();
        if(buttonSet != null){
            map.setButtonSet(buttonSet.stream().map(item -> mapper.map(item,ButtonDto.class)).collect(Collectors.toSet()));
        }
        return map;
    }
}
