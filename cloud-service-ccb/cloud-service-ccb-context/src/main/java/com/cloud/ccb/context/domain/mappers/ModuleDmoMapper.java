package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.ModuleDmo;
import com.cloud.ccb.context.domain.mappers.dmo.ModuleDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleDmoMapper {
    int countByExample(ModuleDmoExample example);

    int deleteByExample(ModuleDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ModuleDmo record);

    int insertSelective(ModuleDmo record);

    List<ModuleDmo> selectByExample(ModuleDmoExample example);

    ModuleDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ModuleDmo record, @Param("example") ModuleDmoExample example);

    int updateByExample(@Param("record") ModuleDmo record, @Param("example") ModuleDmoExample example);

    int updateByPrimaryKeySelective(ModuleDmo record);

    int updateByPrimaryKey(ModuleDmo record);
}