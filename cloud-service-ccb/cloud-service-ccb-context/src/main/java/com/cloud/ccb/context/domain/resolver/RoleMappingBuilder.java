package com.cloud.ccb.context.domain.resolver;

import com.cloud.ccb.api.dto.RoleDto;
import com.cloud.ccb.context.domain.mappers.dmo.RoleDmo;
import com.cloud.ccb.context.domain.model.Role;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-16 13:53
 **/
@Component
public class RoleMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(Role.class).accessible(true), RoleDmo.class)
                .fields("description","description")
                .fields("name", "name");

        mapping(type(Role.class).accessible(true), RoleDto.class)
                .fields("menus","menus")
                .fields("description","description")
                .fields("name", "name");
    }
}
