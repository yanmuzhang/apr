package com.cloud.ccb.context.domain.query;

import cn.liberfree.common.Page;
import cn.liberfree.mybatis.PageParames;
import org.apache.ibatis.annotations.Param;

public interface MenuQuery {

    Page<String> list(@Param("name") String name, @Param("isLeaf") Boolean isLeaf,PageParames pageParames);

}
