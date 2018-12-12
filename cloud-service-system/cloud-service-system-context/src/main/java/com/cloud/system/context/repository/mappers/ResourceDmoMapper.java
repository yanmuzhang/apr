package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.ResourceDmo;
import com.cloud.system.context.repository.mappers.dmo.ResourceDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceDmoMapper {
    int countByExample(ResourceDmoExample example);

    int deleteByExample(ResourceDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResourceDmo record);

    int insertSelective(ResourceDmo record);

    List<ResourceDmo> selectByExample(ResourceDmoExample example);

    ResourceDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResourceDmo record, @Param("example") ResourceDmoExample example);

    int updateByExample(@Param("record") ResourceDmo record, @Param("example") ResourceDmoExample example);

    int updateByPrimaryKeySelective(ResourceDmo record);

    int updateByPrimaryKey(ResourceDmo record);
}