package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.OperatorDmo;
import com.cloud.ccb.context.domain.mappers.dmo.OperatorDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorDmoMapper {
    int countByExample(OperatorDmoExample example);

    int deleteByExample(OperatorDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(OperatorDmo record);

    int insertSelective(OperatorDmo record);

    List<OperatorDmo> selectByExample(OperatorDmoExample example);

    OperatorDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OperatorDmo record, @Param("example") OperatorDmoExample example);

    int updateByExample(@Param("record") OperatorDmo record, @Param("example") OperatorDmoExample example);

    int updateByPrimaryKeySelective(OperatorDmo record);

    int updateByPrimaryKey(OperatorDmo record);
}