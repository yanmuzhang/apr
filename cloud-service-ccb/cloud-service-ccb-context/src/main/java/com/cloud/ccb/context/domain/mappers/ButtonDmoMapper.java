package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.ButtonDmo;
import com.cloud.ccb.context.domain.mappers.dmo.ButtonDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ButtonDmoMapper {
    int countByExample(ButtonDmoExample example);

    int deleteByExample(ButtonDmoExample example);

    int insert(ButtonDmo record);

    int insertSelective(ButtonDmo record);

    List<ButtonDmo> selectByExample(ButtonDmoExample example);

    int updateByExampleSelective(@Param("record") ButtonDmo record, @Param("example") ButtonDmoExample example);

    int updateByExample(@Param("record") ButtonDmo record, @Param("example") ButtonDmoExample example);
}