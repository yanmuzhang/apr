package com.cloud.ccb.context.domain.query;

import cn.liberfree.common.Page;
import cn.liberfree.mybatis.PageParames;
import org.apache.ibatis.annotations.Param;

public interface AppQuery {

    Integer isExistence(@Param("name") String name,@Param("excludeId") String excludeId);

    Page<String> getAppList(@Param("orgId") String orgId, @Param("name") String name, PageParames pageParames);
}
