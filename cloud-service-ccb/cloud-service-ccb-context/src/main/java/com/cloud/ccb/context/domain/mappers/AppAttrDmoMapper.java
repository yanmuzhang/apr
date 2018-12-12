package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.AppAttrDmo;
import com.cloud.ccb.context.domain.mappers.dmo.AppAttrDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppAttrDmoMapper {
    int countByExample(AppAttrDmoExample example);

    int deleteByExample(AppAttrDmoExample example);

    int insert(AppAttrDmo record);

    int insertSelective(AppAttrDmo record);

    List<AppAttrDmo> selectByExample(AppAttrDmoExample example);

    int updateByExampleSelective(@Param("record") AppAttrDmo record, @Param("example") AppAttrDmoExample example);

    int updateByExample(@Param("record") AppAttrDmo record, @Param("example") AppAttrDmoExample example);
}