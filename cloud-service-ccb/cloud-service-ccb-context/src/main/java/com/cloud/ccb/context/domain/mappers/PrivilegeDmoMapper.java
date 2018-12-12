package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.PrivilegeDmo;
import com.cloud.ccb.context.domain.mappers.dmo.PrivilegeDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivilegeDmoMapper {
    int countByExample(PrivilegeDmoExample example);

    int deleteByExample(PrivilegeDmoExample example);

    int insert(PrivilegeDmo record);

    int insertSelective(PrivilegeDmo record);

    List<PrivilegeDmo> selectByExample(PrivilegeDmoExample example);

    int updateByExampleSelective(@Param("record") PrivilegeDmo record, @Param("example") PrivilegeDmoExample example);

    int updateByExample(@Param("record") PrivilegeDmo record, @Param("example") PrivilegeDmoExample example);
}