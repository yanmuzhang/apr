package com.cloud.ccb.context.domain.service;

import com.cloud.ccb.api.dto.ButtonDto;
import com.cloud.ccb.api.dto.MenuDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MenuServiceTest extends BaseServiceTest{


    @Autowired
    MenuService menuService;

    @Test
    public void addMenu() {

        MenuDto menuDto = new MenuDto();
        menuDto.setName("控制面板");
        menuDto.setIcon("dashboard");
        menuDto.setIsLeaf(false);
        menuDto.setMenuNo("DASHBOARD");
        menuDto.setIsVisible(true);
        menuDto.setOrderList(1);
        menuDto.setUrl("/dashboard");

        Set<ButtonDto> buttonDtos  = new HashSet<>();
        ButtonDto buttonDto = new ButtonDto();
        buttonDto.setBtnIcon("icon-add");
        buttonDto.setBtnName("待办事项");
        buttonDto.setBtnType("BIG-BUTTON");
        buttonDto.setBtnNo("BIG-BUTTON");
        buttonDto.setInitStatus(true);
        buttonDtos.add(buttonDto);
        menuDto.setButtonSet(buttonDtos);
        menuService.addMenu(menuDto);

        MenuDto menuDto1 = new MenuDto();
        menuDto1.setName("开放平台");
        menuDto1.setIcon("example");
        menuDto1.setIsLeaf(false);
        menuDto1.setMenuNo("DASHBOARD");
        menuDto1.setIsVisible(true);
        menuDto1.setOrderList(1);
        menuDto1.setUrl("/open");
        menuService.addMenu(menuDto1);

    }

    @Test
    public void editMenu() {
    }

    @Test
    public void getMenu() {
    }
}