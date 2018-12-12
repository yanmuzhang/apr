package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.AppDmo;
import com.cloud.ccb.context.domain.mappers.dmo.AppDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppDmoMapper {
    int countByExample(AppDmoExample example);

    int deleteByExample(AppDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AppDmo record);

    int insertSelective(AppDmo record);

    List<AppDmo> selectByExample(AppDmoExample example);

    AppDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppDmo record, @Param("example") AppDmoExample example);

    int updateByExample(@Param("record") AppDmo record, @Param("example") AppDmoExample example);

    int updateByPrimaryKeySelective(AppDmo record);

    int updateByPrimaryKey(AppDmo record);
}