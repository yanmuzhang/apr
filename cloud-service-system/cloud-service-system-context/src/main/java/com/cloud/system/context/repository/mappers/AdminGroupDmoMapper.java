package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.AdminGroupDmo;
import com.cloud.system.context.repository.mappers.dmo.AdminGroupDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminGroupDmoMapper {
    int countByExample(AdminGroupDmoExample example);

    int deleteByExample(AdminGroupDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdminGroupDmo record);

    int insertSelective(AdminGroupDmo record);

    List<AdminGroupDmo> selectByExample(AdminGroupDmoExample example);

    AdminGroupDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdminGroupDmo record, @Param("example") AdminGroupDmoExample example);

    int updateByExample(@Param("record") AdminGroupDmo record, @Param("example") AdminGroupDmoExample example);

    int updateByPrimaryKeySelective(AdminGroupDmo record);

    int updateByPrimaryKey(AdminGroupDmo record);
}