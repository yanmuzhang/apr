package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.AppDto;
import com.cloud.ccb.context.domain.model.App;

import java.util.List;

public interface AppService {

    void addApp(AppDto appDto);

    void updateApp(AppDto appDto);

    AppDto getApp(String id);

    PageResult<AppDto> getAppList(String orgId,String name, int pageIndex, int pageSize);
}
