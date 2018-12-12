package com.cloud.ccb.context.domain.resolver;

import com.cloud.ccb.context.domain.mappers.dmo.OperatorDmo;
import com.cloud.ccb.context.domain.model.Operator;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-16 13:53
 **/
@Component
public class OperatorMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(type(Operator.class).accessible(true), OperatorDmo.class)
                .fields("peopleId", "peopleId")
                .fields("appId", "appId");




    }
}
