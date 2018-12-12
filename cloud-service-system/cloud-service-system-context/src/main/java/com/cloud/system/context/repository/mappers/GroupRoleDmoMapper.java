package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.GroupRoleDmo;
import com.cloud.system.context.repository.mappers.dmo.GroupRoleDmoExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupRoleDmoMapper {
    int countByExample(GroupRoleDmoExample example);

    int deleteByExample(GroupRoleDmoExample example);

    int deleteByPrimaryKey(Date createTime);

    int insert(GroupRoleDmo record);

    int insertSelective(GroupRoleDmo record);

    List<GroupRoleDmo> selectByExample(GroupRoleDmoExample example);

    GroupRoleDmo selectByPrimaryKey(Date createTime);

    int updateByExampleSelective(@Param("record") GroupRoleDmo record, @Param("example") GroupRoleDmoExample example);

    int updateByExample(@Param("record") GroupRoleDmo record, @Param("example") GroupRoleDmoExample example);

    int updateByPrimaryKeySelective(GroupRoleDmo record);

    int updateByPrimaryKey(GroupRoleDmo record);
}