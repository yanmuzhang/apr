package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.OperatorAttrDmo;
import com.cloud.ccb.context.domain.mappers.dmo.OperatorAttrDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorAttrDmoMapper {
    int countByExample(OperatorAttrDmoExample example);

    int deleteByExample(OperatorAttrDmoExample example);

    int deleteByPrimaryKey(String operatorId);

    int insert(OperatorAttrDmo record);

    int insertSelective(OperatorAttrDmo record);

    List<OperatorAttrDmo> selectByExample(OperatorAttrDmoExample example);

    OperatorAttrDmo selectByPrimaryKey(String operatorId);

    int updateByExampleSelective(@Param("record") OperatorAttrDmo record, @Param("example") OperatorAttrDmoExample example);

    int updateByExample(@Param("record") OperatorAttrDmo record, @Param("example") OperatorAttrDmoExample example);

    int updateByPrimaryKeySelective(OperatorAttrDmo record);

    int updateByPrimaryKey(OperatorAttrDmo record);
}