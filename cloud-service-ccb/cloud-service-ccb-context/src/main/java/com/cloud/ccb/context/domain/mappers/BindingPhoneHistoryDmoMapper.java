package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.BindingPhoneHistoryDmo;
import com.cloud.ccb.context.domain.mappers.dmo.BindingPhoneHistoryDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BindingPhoneHistoryDmoMapper {
    int countByExample(BindingPhoneHistoryDmoExample example);

    int deleteByExample(BindingPhoneHistoryDmoExample example);

    int insert(BindingPhoneHistoryDmo record);

    int insertSelective(BindingPhoneHistoryDmo record);

    List<BindingPhoneHistoryDmo> selectByExample(BindingPhoneHistoryDmoExample example);

    int updateByExampleSelective(@Param("record") BindingPhoneHistoryDmo record, @Param("example") BindingPhoneHistoryDmoExample example);

    int updateByExample(@Param("record") BindingPhoneHistoryDmo record, @Param("example") BindingPhoneHistoryDmoExample example);
}