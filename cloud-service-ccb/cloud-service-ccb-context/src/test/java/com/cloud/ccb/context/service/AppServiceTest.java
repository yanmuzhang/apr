package com.cloud.ccb.context.service;

import cn.liberfree.common.JsonUtils;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.model.AppAttr;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class AppServiceTest  extends BaseServiceTest{


    @Autowired
    private AppService appService;

    @Test
    public void list() {
        List<App> list = appService.list("");
        System.out.println(JsonUtils.convertObjectToJSON(list));
    }

    @Test
    public void save() {
        App app = new App();
        Set<AppAttr> appAttrs = new HashSet<>();
        appAttrs.add(new AppAttr().init(null,"sex","String",false,"UNKNOWN",1));
        appAttrs.add(new AppAttr().init(null,"icon","String",false,"",1));
        appAttrs.add(new AppAttr().init(null,"nickName","String",false,"",1));
        appAttrs.add(new AppAttr().init(null,"age","Integer",false,"",1));
        app.init("记账管家","F05BD2AB178443A6B3478399FADA28F6",appAttrs);
        appService.save(app);
    }
}