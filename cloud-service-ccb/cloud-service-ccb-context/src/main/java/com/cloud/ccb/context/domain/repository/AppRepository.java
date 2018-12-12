package com.cloud.ccb.context.domain.repository;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.core.EntityObjectUtils;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.IRepository;
import com.cloud.ccb.context.domain.mappers.AppAttrDmoMapper;
import com.cloud.ccb.context.domain.mappers.AppDmoMapper;
import com.cloud.ccb.context.domain.mappers.dmo.AppAttrDmo;
import com.cloud.ccb.context.domain.mappers.dmo.AppAttrDmoExample;
import com.cloud.ccb.context.domain.mappers.dmo.AppDmo;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.model.AppAttr;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-13 11:17
 **/
@Component
public class AppRepository implements IRepository<App,String> {

    @Autowired
    private AppDmoMapper appDmoMapper;

    @Autowired
    private AppAttrDmoMapper appAttrDmoMapper;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public App load(String id, EntityLoader loader) {
        if(ObjectUtils.isEmpty(id)){
            throw new BusinessException("id 不能为空");
        }
        AppDmo appDmo = appDmoMapper.selectByPrimaryKey(String.valueOf(id));
        if(appDmo == null){
            return null;
        }
        App app = loader.create(appDmo.getId(),App.class);
        mapper.map(appDmo,app);
        AppAttrDmoExample appAttrDmoExample = new AppAttrDmoExample();
        appAttrDmoExample.createCriteria().andAppIdEqualTo(app.getId());
        List<AppAttrDmo> appAttrDmos = appAttrDmoMapper.selectByExample(appAttrDmoExample);

        Set<AppAttr> collect = appAttrDmos.stream().map(i -> {
            AppAttr appAttr = new AppAttr();
            appAttr.init(i.getAppId(),i.getName(),i.getType(),i.getRequired(),i.getDefaultValue(),i.getSort().intValue());
            return appAttr;
        }).collect(Collectors.toSet());
        EntityObjectUtils.setValue(App.class,app,"appAttrs",collect);
        return app;
    }

    @Override
    public void save(App app) {
        if(ObjectUtils.isEmpty(app)){
            throw new BusinessException("app 不能为空");
        }

        AppDmo map = mapper.map(app, AppDmo.class);

        map.setId(app.getId());
        map.setName(app.getName());
        map.setOrganizationId(app.getOrganizationId());


        if(appDmoMapper.updateByPrimaryKey(map) == 0){
            appDmoMapper.insert(map);
        }

        Set<AppAttr> appAttrs = app.getAppAttrs();
        AppAttrDmoExample appAttrDmoExample = new AppAttrDmoExample();
        appAttrDmoExample.createCriteria().andAppIdEqualTo(app.getId());
        appAttrDmoMapper.deleteByExample(appAttrDmoExample);
        appAttrs.stream().map(i -> {
            AppAttrDmo appAttr = mapper.map(i,AppAttrDmo.class);
            appAttr.setAppId(app.getId());
            return  appAttr;
        }).forEach(i->appAttrDmoMapper.insert(i));

    }

    @Override
    public void delete(App app) {
        if(ObjectUtils.isEmpty(app)){
            throw new BusinessException("id 不能为空");
        }
        appDmoMapper.deleteByPrimaryKey(app.getId());
        AppAttrDmoExample appAttrDmoExample = new AppAttrDmoExample();
        appAttrDmoExample.createCriteria().andAppIdEqualTo(app.getId());
        appAttrDmoMapper.deleteByExample(appAttrDmoExample);
    }
}
