package com.cloud.blog.context.repository.mappers;

import com.cloud.blog.context.repository.mappers.dmo.SettingDmo;
import com.cloud.blog.context.repository.mappers.dmo.SettingDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettingDmoMapper {
    int countByExample(SettingDmoExample example);

    int deleteByExample(SettingDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SettingDmo record);

    int insertSelective(SettingDmo record);

    List<SettingDmo> selectByExample(SettingDmoExample example);

    SettingDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SettingDmo record, @Param("example") SettingDmoExample example);

    int updateByExample(@Param("record") SettingDmo record, @Param("example") SettingDmoExample example);

    int updateByPrimaryKeySelective(SettingDmo record);

    int updateByPrimaryKey(SettingDmo record);
}