package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.LoginInfoDmo;
import com.cloud.ccb.context.domain.mappers.dmo.LoginInfoDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginInfoDmoMapper {
    int countByExample(LoginInfoDmoExample example);

    int deleteByExample(LoginInfoDmoExample example);

    int deleteByPrimaryKey(String peopleId);

    int insert(LoginInfoDmo record);

    int insertSelective(LoginInfoDmo record);

    List<LoginInfoDmo> selectByExample(LoginInfoDmoExample example);

    LoginInfoDmo selectByPrimaryKey(String peopleId);

    int updateByExampleSelective(@Param("record") LoginInfoDmo record, @Param("example") LoginInfoDmoExample example);

    int updateByExample(@Param("record") LoginInfoDmo record, @Param("example") LoginInfoDmoExample example);

    int updateByPrimaryKeySelective(LoginInfoDmo record);

    int updateByPrimaryKey(LoginInfoDmo record);
}