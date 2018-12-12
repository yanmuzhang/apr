package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.RoleDmo;
import com.cloud.system.context.repository.mappers.dmo.RoleDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDmoMapper {
    int countByExample(RoleDmoExample example);

    int deleteByExample(RoleDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleDmo record);

    int insertSelective(RoleDmo record);

    List<RoleDmo> selectByExample(RoleDmoExample example);

    RoleDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleDmo record, @Param("example") RoleDmoExample example);

    int updateByExample(@Param("record") RoleDmo record, @Param("example") RoleDmoExample example);

    int updateByPrimaryKeySelective(RoleDmo record);

    int updateByPrimaryKey(RoleDmo record);
}