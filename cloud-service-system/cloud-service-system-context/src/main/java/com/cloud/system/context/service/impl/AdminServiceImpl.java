package com.cloud.system.context.service.impl;

import com.cloud.common.Page;
import com.cloud.common.PageResult;
import com.cloud.common.execption.BusinessExecption;
import com.cloud.common.pojo.PojoMapper;
import com.cloud.ddd.loader.EntityLoader;
import com.cloud.mybatis.PageParames;
import com.cloud.system.api.dto.AdminDto;
import com.cloud.system.context.repository.mappers.AdminDmoMapper;
import com.cloud.system.context.repository.mappers.dmo.AdminDmo;
import com.cloud.system.context.repository.mappers.dmo.AdminDmoExample;
import com.cloud.system.context.repository.model.Admin;
import com.cloud.system.context.repository.query.AdminQuery;
import com.cloud.system.context.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-08-21 14:53
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDmoMapper adminDmoMapper;

    EntityLoader entityLoader = new EntityLoader();

    @Autowired
    AdminQuery adminQuery;

    @Autowired
    private PojoMapper pojo;

    @Override
    public String login(String username, String password) {
        String digPassword  = DigestUtils.md5DigestAsHex(password.getBytes());

        AdminDmoExample adminDmoExample = new AdminDmoExample();
        adminDmoExample.createCriteria().andUsernameEqualTo(username);
        List<AdminDmo> adminDmos = adminDmoMapper.selectByExample(adminDmoExample);
        AdminDmo adminDmo = null;
        if(adminDmos.size() > 0){
            adminDmo = adminDmos.get(0);
        }
        if(ObjectUtils.isEmpty(adminDmo)){
            throw  new BusinessExecption("用户名不存在");
        }
        if(!StringUtils.equals(digPassword,adminDmo.getPassword())){
            throw  new BusinessExecption("密码错误");
        }
        return adminDmo.getId();
    }

    @Override
    public AdminDto getAdmin(String id) {
        Admin admin = entityLoader.load(id,Admin.class);
        if(ObjectUtils.isEmpty(admin)){
            throw  new BusinessExecption("ID不存在");
        }
        AdminDto adminDto = pojo.map(admin, AdminDto.class);
        adminDto.setId(admin.getId());
        return adminDto;
    }

    @Override
    public PageResult<AdminDto> list(Page<AdminDto> page) {
        Page<String> list = adminQuery.list(PageParames.create(page.getPageIndex(), page.getPageSize()));
        List<AdminDto> rows = list.getRows().stream().map(id -> {
            Admin admin = entityLoader.load(id, Admin.class);
            AdminDto adminDto = pojo.map(admin, AdminDto.class);
            adminDto.setId(admin.getId());
            return adminDto;
        }).collect(Collectors.toList());

        page.setRows(rows);
        page.setTotalCount(list.getTotalCount());

        return PageResult.build(page);
    }

    @Override
    public String save(AdminDto adminDto) {
        Admin admin = entityLoader.create(Admin.class);
        pojo.map(adminDto, admin);
        return admin.getId();
    }

    @Override
    public void update(AdminDto adminDto) {
        Admin admin = entityLoader.load(adminDto.getId(),Admin.class);
        pojo.map(adminDto, admin);
        admin.setUpdateTime(new Date());
    }

    @Override
    public void delele(String id) {
        adminDmoMapper.deleteByPrimaryKey(id);
    }
}
