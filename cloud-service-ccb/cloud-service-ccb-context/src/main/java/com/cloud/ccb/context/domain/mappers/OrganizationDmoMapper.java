package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.OrganizationDmo;
import com.cloud.ccb.context.domain.mappers.dmo.OrganizationDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationDmoMapper {
    int countByExample(OrganizationDmoExample example);

    int deleteByExample(OrganizationDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrganizationDmo record);

    int insertSelective(OrganizationDmo record);

    List<OrganizationDmo> selectByExample(OrganizationDmoExample example);

    OrganizationDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrganizationDmo record, @Param("example") OrganizationDmoExample example);

    int updateByExample(@Param("record") OrganizationDmo record, @Param("example") OrganizationDmoExample example);

    int updateByPrimaryKeySelective(OrganizationDmo record);

    int updateByPrimaryKey(OrganizationDmo record);
}