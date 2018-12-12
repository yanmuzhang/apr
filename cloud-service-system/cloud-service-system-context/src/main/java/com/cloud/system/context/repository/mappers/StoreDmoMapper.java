package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.StoreDmo;
import com.cloud.system.context.repository.mappers.dmo.StoreDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreDmoMapper {
    int countByExample(StoreDmoExample example);

    int deleteByExample(StoreDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(StoreDmo record);

    int insertSelective(StoreDmo record);

    List<StoreDmo> selectByExample(StoreDmoExample example);

    StoreDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreDmo record, @Param("example") StoreDmoExample example);

    int updateByExample(@Param("record") StoreDmo record, @Param("example") StoreDmoExample example);

    int updateByPrimaryKeySelective(StoreDmo record);

    int updateByPrimaryKey(StoreDmo record);
}