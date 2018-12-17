package com.cloud.ccb.context.domain.service.impl;

import cn.liberfree.common.Page;
import cn.liberfree.common.PageResult;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.mybatis.PageParames;
import com.cloud.ccb.api.dto.RoleDto;
import com.cloud.ccb.context.domain.model.Role;
import com.cloud.ccb.context.domain.query.RoleQuery;
import com.cloud.ccb.context.domain.service.RoleService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-20 16:23
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private EntityLoader entityLoader;

    @Autowired
    private RoleQuery roleQuery;


    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public RoleDto getRole(String id) {
        Role role = entityLoader.load(id,Role.class);
        return mapper.map(role,RoleDto.class);
    }

    @Override
    public PageResult<RoleDto> getPageList(String name, Integer pageIndex, Integer pageSize) {
        PageParames pageParames = PageParames.create(pageIndex, pageSize);
        Page<String> page = roleQuery.list(name,pageParames);
        List<RoleDto> collect = page.getRows().stream().map(id -> getRole(id)).collect(Collectors.toList());

        Page<RoleDto>  pageList = new Page<>();
        pageList.setPageIndex(pageIndex);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(page.getTotalCount());
        pageList.setRows(collect);
        return PageResult.build(pageList);
    }

    @Override
    public void addRole(RoleDto roleDto) {
        Role role = entityLoader.create(Role.class);
        role.init(roleDto.getName(),roleDto.getDescription(),roleDto.getMenus());
    }

    @Override
    public void editRole(RoleDto roleDto) {
        Role role = entityLoader.load(roleDto.getId(),Role.class);
        role.edit(roleDto.getName(),roleDto.getDescription(),roleDto.getMenus());
    }


    @Override
    public void delete(String id) {
        Role role = entityLoader.load(id,Role.class);
        role.delete();
    }
}
