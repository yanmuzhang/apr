package com.cloud.system.context.repository;

import com.cloud.common.IdentifyUtils;
import com.cloud.common.JsonUtils;
import com.cloud.common.execption.BusinessExecption;
import com.cloud.common.pojo.PojoMapper;
import com.cloud.ddd.loader.EntityLoader;
import com.cloud.ddd.repository.IRepository;
import com.cloud.system.context.repository.mappers.AdminDmoMapper;
import com.cloud.system.context.repository.mappers.AdminGroupDmoMapper;
import com.cloud.system.context.repository.mappers.GroupDmoMapper;
import com.cloud.system.context.repository.mappers.dmo.*;
import com.cloud.system.context.repository.model.Admin;
import com.cloud.system.context.repository.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-08-22 15:13
 **/
@Component
@Slf4j
public class AdminRepository implements IRepository<Admin> {

    @Autowired
    private AdminDmoMapper adminDmoMapper;
    @Autowired
    private AdminGroupDmoMapper adminGroupDmoMapper;
    @Autowired
    private GroupDmoMapper groupDmoMapper;


    @Autowired
    private PojoMapper pojo;


    @Override
    public Admin load(Object id,EntityLoader loader) {
        AdminDmo adminDmo = adminDmoMapper.selectByPrimaryKey(id.toString());
        if(ObjectUtils.isEmpty(adminDmo)){
            return null;
        }
        log.info("AdminDmo:"+JsonUtils.convertObjectToJSON(adminDmo));

        Admin admin = loader.create(Admin.class);
        log.info("admin1:"+JsonUtils.convertObjectToJSON(admin));
        pojo.map(adminDmo,admin);
        log.info("admin2:"+JsonUtils.convertObjectToJSON(admin));

        AdminGroupDmoExample adminGroupDmoExample = new AdminGroupDmoExample();
        adminGroupDmoExample.createCriteria().andAdminIdEqualTo(admin.getId());
        List<AdminGroupDmo> adminGroupDmos = adminGroupDmoMapper.selectByExample(adminGroupDmoExample);
        if(adminGroupDmos.size()>0){

            List<String> collect = adminGroupDmos.stream().map(item -> item.getAdminId()).collect(Collectors.toList());
            GroupDmoExample groupDmoExample = new GroupDmoExample();
            groupDmoExample.createCriteria().andIdIn(collect);
            List<GroupDmo> groupDmos = groupDmoMapper.selectByExample(new GroupDmoExample());

            List<Group> collect1 = groupDmos.stream().map(item -> {
                Group group  =new Group();
                BeanUtils.copyProperties(item,group);
                return group;
            }).collect(Collectors.toList());

            admin.setGroupSet(new HashSet<Group>(collect1));
        }
        return admin;
    }

    @Override
    public void save(Admin object) {
        if(ObjectUtils.isEmpty(object)){
            throw new BusinessExecption("object is null");
        }
        AdminDmo adminDmo = pojo.map(object, AdminDmo.class);
        adminDmo.setId(object.getId());
        Set<Group> groupSet = object.getGroupSet();
        if(groupSet != null){
            groupSet.forEach(item -> {
                GroupDmo groupDmo = new GroupDmo();
                BeanUtils.copyProperties(item,groupDmo);
                if(groupDmoMapper.updateByPrimaryKey(groupDmo) == 0){
                    groupDmoMapper.insert(groupDmo);
                }
                AdminGroupDmoExample adminGroupDmoExample = new AdminGroupDmoExample();
                adminGroupDmoExample.createCriteria().andAdminIdEqualTo(adminDmo.getId()).andGroupIdEqualTo(item.getId());
                adminGroupDmoMapper.deleteByExample(adminGroupDmoExample);
                AdminGroupDmo adminGroupDmo = new AdminGroupDmo();
                adminGroupDmo.setAdminId(adminDmo.getId());
                adminGroupDmo.setGroupId(groupDmo.getId());
                adminGroupDmo.setId(IdentifyUtils.uuid());
                adminGroupDmo.setCreateTime(new Date());
                adminGroupDmo.setUpdateTime(new Date());
                adminGroupDmoMapper.insert(adminGroupDmo);
            });
        }

        if(adminDmoMapper.updateByPrimaryKey(adminDmo) == 0){
            adminDmoMapper.insert(adminDmo);
        }
    }

    @Override
    public void delete(Object id) {
        adminDmoMapper.deleteByPrimaryKey(id.toString());
    }
}
