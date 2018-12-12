package com.cloud.system.context.repository.resolver;

import com.cloud.common.pojo.AbstrctPojoConfig;
import com.cloud.common.pojo.PojoConfig;
import com.cloud.system.api.dto.AdminDto;
import com.cloud.system.context.repository.mappers.dmo.AdminDmo;
import com.cloud.system.context.repository.model.Admin;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-09-05 11:21
 **/
@Component
public class AdminPojoMappingConfig extends AbstrctPojoConfig {
    @Override
    public void config(PojoConfig pojoConfig) throws NoSuchFieldException {
        pojoConfig.mapping(Admin.class,AdminDmo.class,AdminDto.class)
                .fileds("id","id","id")
                .fileds("createTime","createTime","createTime")
                .fileds("updateTime","updateTime","updateTime")
                .fileds("username","username","username")
                .fileds("password","password","password")
                .fileds("passwordSalt","passwordSalt","passwordSalt")
                .fileds();
    }
}
