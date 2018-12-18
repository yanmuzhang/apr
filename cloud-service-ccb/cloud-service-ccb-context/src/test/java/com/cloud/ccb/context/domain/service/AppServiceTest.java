package com.cloud.ccb.context.domain.service;

import cn.liberfree.common.JsonUtils;
import cn.liberfree.common.PageResult;
import com.cloud.ccb.api.dto.AppDto;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.model.AppAttr;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class AppServiceTest  extends BaseServiceTest{


    @Autowired
    private AppService appService;

    @Test
    public void list() {
        PageResult<AppDto> list = appService.getAppList(null, null, 1, 19);
        System.out.println(JsonUtils.convertObjectToJSON(list));
    }

    @Test
    public void save() {
//        App app = new App();
//        Set<AppAttr> appAttrs = new HashSet<>();
//        appAttrs.add(new AppAttr().init(null,"sex","String",false,"UNKNOWN",1));
//        appAttrs.add(new AppAttr().init(null,"icon","String",false,"",1));
//        appAttrs.add(new AppAttr().init(null,"nickName","String",false,"",1));
//        appAttrs.add(new AppAttr().init(null,"age","Integer",false,"",1));
//        app.init("记账管家","F05BD2AB178443A6B3478399FADA28F6",appAttrs);
//        appService.addApp(app);
    }
}