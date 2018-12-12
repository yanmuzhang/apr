package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.PeopleDmo;
import com.cloud.ccb.context.domain.mappers.dmo.PeopleDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeopleDmoMapper {
    int countByExample(PeopleDmoExample example);

    int deleteByExample(PeopleDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeopleDmo record);

    int insertSelective(PeopleDmo record);

    List<PeopleDmo> selectByExample(PeopleDmoExample example);

    PeopleDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeopleDmo record, @Param("example") PeopleDmoExample example);

    int updateByExample(@Param("record") PeopleDmo record, @Param("example") PeopleDmoExample example);

    int updateByPrimaryKeySelective(PeopleDmo record);

    int updateByPrimaryKey(PeopleDmo record);
}