package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.OperatorRoleDmo;
import com.cloud.ccb.context.domain.mappers.dmo.OperatorRoleDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorRoleDmoMapper {
    int countByExample(OperatorRoleDmoExample example);

    int deleteByExample(OperatorRoleDmoExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(OperatorRoleDmo record);

    int insertSelective(OperatorRoleDmo record);

    List<OperatorRoleDmo> selectByExample(OperatorRoleDmoExample example);

    OperatorRoleDmo selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") OperatorRoleDmo record, @Param("example") OperatorRoleDmoExample example);

    int updateByExample(@Param("record") OperatorRoleDmo record, @Param("example") OperatorRoleDmoExample example);

    int updateByPrimaryKeySelective(OperatorRoleDmo record);

    int updateByPrimaryKey(OperatorRoleDmo record);
}