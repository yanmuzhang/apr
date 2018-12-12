package com.cloud.system.context.repository.query;

import com.cloud.common.Page;
import com.cloud.mybatis.PageParames;
import com.cloud.system.context.repository.mappers.dmo.AdminDmo;

public interface AdminQuery {
    Page<String> list(PageParames pageParames);
}
