package com.cloud.user.context.repository.mappers;

import com.cloud.user.context.repository.mappers.dmo.UserLoginDmo;
import com.cloud.user.context.repository.mappers.dmo.UserLoginDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginDmoMapper {
    int countByExample(UserLoginDmoExample example);

    int deleteByExample(UserLoginDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserLoginDmo record);

    int insertSelective(UserLoginDmo record);

    List<UserLoginDmo> selectByExample(UserLoginDmoExample example);

    UserLoginDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserLoginDmo record, @Param("example") UserLoginDmoExample example);

    int updateByExample(@Param("record") UserLoginDmo record, @Param("example") UserLoginDmoExample example);

    int updateByPrimaryKeySelective(UserLoginDmo record);

    int updateByPrimaryKey(UserLoginDmo record);
}