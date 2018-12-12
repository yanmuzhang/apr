package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.AdminLoginDmo;
import com.cloud.system.context.repository.mappers.dmo.AdminLoginDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginDmoMapper {
    int countByExample(AdminLoginDmoExample example);

    int deleteByExample(AdminLoginDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdminLoginDmo record);

    int insertSelective(AdminLoginDmo record);

    List<AdminLoginDmo> selectByExample(AdminLoginDmoExample example);

    AdminLoginDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdminLoginDmo record, @Param("example") AdminLoginDmoExample example);

    int updateByExample(@Param("record") AdminLoginDmo record, @Param("example") AdminLoginDmoExample example);

    int updateByPrimaryKeySelective(AdminLoginDmo record);

    int updateByPrimaryKey(AdminLoginDmo record);
}