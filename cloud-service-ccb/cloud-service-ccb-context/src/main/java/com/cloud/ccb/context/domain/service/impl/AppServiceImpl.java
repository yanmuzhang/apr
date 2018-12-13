package com.cloud.ccb.context.domain.service.impl;

import cn.liberfree.common.AssertUtils;
import cn.liberfree.common.Page;
import cn.liberfree.common.PageResult;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.mybatis.PageParames;
import com.cloud.ccb.api.dto.AppDto;
import com.cloud.ccb.api.dto.OperatorInfoDto;
import com.cloud.ccb.context.domain.model.App;
import com.cloud.ccb.context.domain.model.AppAttr;
import com.cloud.ccb.context.domain.query.AppQuery;
import com.cloud.ccb.context.domain.service.AppService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;
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

    @Autowired
    private DozerBeanMapper beanMapper;


    @Override
    public void addApp(AppDto appDto) {
        AssertUtils.notNull(appDto,"缺少参数[name]");
        AssertUtils.notEmpty(appDto.getName(),"应用名称不能为空");
        AssertUtils.notEmpty(appDto.getOrganizationId(),"机构ID不能为空");
        Integer existence = appQuery.isExistence(appDto.getName(), null);
        AssertUtils.isTrue(existence == 0,"应用名称已存在");



        App app = loader.create(App.class);
        Set<AppAttr> collect = null;
        if(appDto.getAppAttrs() != null){
            collect = appDto.getAppAttrs().stream().map(item -> beanMapper.map(item, AppAttr.class)).collect(Collectors.toSet());
        }
        app.init(appDto.getName(),appDto.getOrganizationId(),collect);
    }

    @Override
    public void updateApp(AppDto appDto) {
        AssertUtils.notNull(appDto,"缺少参数[name]");
        AssertUtils.notEmpty(appDto.getName(),"应用名称不能为空");
        AssertUtils.notEmpty(appDto.getOrganizationId(),"机构ID不能为空");

        App app = loader.load(appDto.getId(), App.class);
        Integer existence = appQuery.isExistence(appDto.getName(), app.getId());
        AssertUtils.isTrue(existence == 0,"应用名称已存在");

        Set<AppAttr> collect = null;
        if(appDto.getAppAttrs() != null){
            collect = appDto.getAppAttrs().stream().map(item -> beanMapper.map(item, AppAttr.class)).collect(Collectors.toSet());
        }
        app.edit(appDto.getName(),appDto.getOrganizationId(),collect);
    }

    @Override
    public AppDto getApp(String id) {
        App app = loader.load(id, App.class);
        AssertUtils.notNull(app,"应用不存在");
        return beanMapper.map(app,AppDto.class);
    }

    @Override
    public PageResult<AppDto> getAppList(String orgId,String name, int pageIndex, int pageSize) {
        Page<String> page = appQuery.getAppList(orgId,name,PageParames.create(pageIndex,pageSize));
        List<AppDto> collect = page.getRows().stream().map(id -> getApp(id)).collect(Collectors.toList());

        Page<AppDto>  pageList = new Page<>();
        pageList.setPageIndex(pageIndex);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(page.getTotalCount());
        pageList.setRows(collect);
        return PageResult.build(pageList);
    }

}
