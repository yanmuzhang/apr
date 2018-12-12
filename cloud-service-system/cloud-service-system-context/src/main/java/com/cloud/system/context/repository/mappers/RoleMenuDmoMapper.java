package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.RoleMenuDmo;
import com.cloud.system.context.repository.mappers.dmo.RoleMenuDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuDmoMapper {
    int countByExample(RoleMenuDmoExample example);

    int deleteByExample(RoleMenuDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleMenuDmo record);

    int insertSelective(RoleMenuDmo record);

    List<RoleMenuDmo> selectByExample(RoleMenuDmoExample example);

    RoleMenuDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleMenuDmo record, @Param("example") RoleMenuDmoExample example);

    int updateByExample(@Param("record") RoleMenuDmo record, @Param("example") RoleMenuDmoExample example);

    int updateByPrimaryKeySelective(RoleMenuDmo record);

    int updateByPrimaryKey(RoleMenuDmo record);
}