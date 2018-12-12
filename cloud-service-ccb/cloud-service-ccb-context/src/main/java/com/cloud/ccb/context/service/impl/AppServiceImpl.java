package com.cloud.ccb.context.service.impl;

import cn.liberfree.de.loader.EntityLoader;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.query.AppQuery;
import com.cloud.ccb.context.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-13 11:49
 **/
@Service
public class AppServiceImpl  implements AppService {

    @Autowired
    private EntityLoader loader;

    @Autowired
    private AppQuery appQuery;

    @Override
    public List<App> list(String orgId) {
        List<String> list = appQuery.list(orgId);
        List<App> collect = list.stream().map(id -> (App)loader.load(id, App.class)).collect(Collectors.toList());
        return collect;
    }


    @Override
    public void save(App app) {
        App dapp = loader.create(App.class);
        dapp.init(app.getName(),app.getOrganizationId(),app.getAppAttrs());
    }
}
