package com.cloud.ccb.context.service;

import com.cloud.ccb.context.domain.model.App;

import java.util.List;

public interface AppService {
    List<App> list(String orgId);
    void save(App app);
}
