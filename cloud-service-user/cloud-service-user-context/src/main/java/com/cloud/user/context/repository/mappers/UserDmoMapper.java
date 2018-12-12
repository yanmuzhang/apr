package com.cloud.user.context.repository.mappers;

import com.cloud.user.context.repository.mappers.dmo.UserDmo;
import com.cloud.user.context.repository.mappers.dmo.UserDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDmoMapper {
    int countByExample(UserDmoExample example);

    int deleteByExample(UserDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserDmo record);

    int insertSelective(UserDmo record);

    List<UserDmo> selectByExample(UserDmoExample example);

    UserDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserDmo record, @Param("example") UserDmoExample example);

    int updateByExample(@Param("record") UserDmo record, @Param("example") UserDmoExample example);

    int updateByPrimaryKeySelective(UserDmo record);

    int updateByPrimaryKey(UserDmo record);
}