package com.cloud.ccb.context.domain.repository;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.IRepository;
import com.cloud.ccb.context.domain.mappers.OrganizationDmoMapper;
import com.cloud.ccb.context.domain.mappers.dmo.OrganizationDmo;
import com.cloud.ccb.context.domain.model.Organization;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zhangchao
 * @time: 2018-11-14 16:31
 **/
@Component
public class OrganizationRepository implements IRepository<Organization,String> {


    @Autowired
    private OrganizationDmoMapper organizationDmoMapper;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Organization load(String id, EntityLoader entityLoader) {
        if(id == null){
            throw new BusinessException("id is null");
        }
        OrganizationDmo organizationDmo = organizationDmoMapper.selectByPrimaryKey(String.valueOf(id));
        if(organizationDmo == null){
            return null;
        }
        Organization organization = entityLoader.create(Organization.class);
        mapper.map(organizationDmo,organization);
        return organization;
    }

    @Override
    public void save(Organization organization) {
        if(organization == null){
            throw new BusinessException("organization is null");
        }

        OrganizationDmo map = mapper.map(organization, OrganizationDmo.class);
        if(organizationDmoMapper.updateByPrimaryKey(map) == 0){
            organizationDmoMapper.insert(map);
        }
    }

    @Override
    public void delete(Organization object) {
        if(object == null){
            throw new BusinessException("id is null");
        }
        organizationDmoMapper.deleteByPrimaryKey(object.getId());
    }
}
