package com.cloud.ccb.context.domain.resolver;

import com.cloud.ccb.context.domain.mappers.dmo.AppAttrDmo;
import com.cloud.ccb.context.domain.mappers.dmo.AppDmo;
import com.cloud.ccb.context.domain.mappers.dmo.PeopleDmo;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.model.AppAttr;
import com.cloud.ccb.context.domain.model.People;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-16 13:53
 **/
@Component
public class AppMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(App.class).accessible(true), AppDmo.class)
                .fields("secret", "secret")
                .fields("name", "name")
                .fields("organizationId", "organizationId");

        mapping(type(AppAttr.class).accessible(true), AppAttrDmo.class)
                .fields("appId", "appId")
                .fields("name", "name")
                .fields("required", "required")
                .fields("defaultValue", "defaultValue")
                .fields("sort", "sort")
                .fields("type", "type");

    }
}
