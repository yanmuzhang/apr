package com.cloud.ccb.context.domain.resolver;

import com.cloud.ccb.context.domain.mappers.dmo.PeopleDmo;
import com.cloud.ccb.context.domain.model.People;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-16 13:53
 **/
@Component
public class PeopleMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(People.class).accessible(true), PeopleDmo.class)
                .fields("phone", "phone");
    }
}
