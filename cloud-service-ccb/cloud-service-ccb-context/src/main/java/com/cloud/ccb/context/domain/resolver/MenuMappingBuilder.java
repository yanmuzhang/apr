package com.cloud.ccb.context.domain.resolver;

import com.cloud.ccb.api.dto.ButtonDto;
import com.cloud.ccb.api.dto.MenuDto;
import com.cloud.ccb.context.domain.mappers.dmo.ButtonDmo;
import com.cloud.ccb.context.domain.mappers.dmo.MenuDmo;
import com.cloud.ccb.context.domain.mappers.dmo.RoleDmo;
import com.cloud.ccb.context.domain.model.Button;
import com.cloud.ccb.context.domain.model.Menu;
import com.cloud.ccb.context.domain.model.Role;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-16 13:53
 **/
@Component
public class MenuMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(Menu.class).accessible(true), MenuDmo.class)
                .fields("name","name")
                .fields("url","url")
                .fields("icon","icon")
                .fields("isVisible","isVisible")
                .fields("isLeaf","isLeaf")
                .fields("menuNo","menuNo")
                .fields("moduleId","moduleId")
                .fields("parentId","parentId")
                .fields("orderList", "orderList");
        mapping(type(Menu.class).accessible(true), MenuDto.class)
                .fields("name","name")
                .fields("url","url")
                .fields("icon","icon")
                .fields("isVisible","isVisible")
                .fields("isLeaf","isLeaf")
                .fields("menuNo","menuNo")
                .fields("moduleId","moduleId")
                .fields("parentId","parentId")
                .fields("orderList", "orderList");

        mapping(type(Button.class).accessible(true), ButtonDmo.class)
                .fields("menuId","menuId")
                .fields("btnNo","btnNo")
                .fields("btnName","btnName")
                .fields("btnType","btnType")
                .fields("btnIcon","btnIcon")
                .fields("initStatus","initStatus") ;
        mapping(type(Button.class).accessible(true), ButtonDto.class)
                .fields("menuId","menuId")
                .fields("btnNo","btnNo")
                .fields("btnName","btnName")
                .fields("btnType","btnType")
                .fields("btnIcon","btnIcon")
                .fields("initStatus","initStatus") ;

    }
}
