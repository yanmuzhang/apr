package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.AdminDmo;
import com.cloud.system.context.repository.mappers.dmo.AdminDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminDmoMapper {
    int countByExample(AdminDmoExample example);

    int deleteByExample(AdminDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdminDmo record);

    int insertSelective(AdminDmo record);

    List<AdminDmo> selectByExample(AdminDmoExample example);

    AdminDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdminDmo record, @Param("example") AdminDmoExample example);

    int updateByExample(@Param("record") AdminDmo record, @Param("example") AdminDmoExample example);

    int updateByPrimaryKeySelective(AdminDmo record);

    int updateByPrimaryKey(AdminDmo record);
}