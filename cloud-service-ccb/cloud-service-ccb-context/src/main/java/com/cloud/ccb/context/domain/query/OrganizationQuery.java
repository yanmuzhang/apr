package com.cloud.ccb.context.domain.query;

import cn.liberfree.common.Page;
import cn.liberfree.mybatis.PageParames;
import org.apache.ibatis.annotations.Param;

public interface OrganizationQuery {

    Page<String> list(@Param("name") String name,PageParames pageParames);


}
