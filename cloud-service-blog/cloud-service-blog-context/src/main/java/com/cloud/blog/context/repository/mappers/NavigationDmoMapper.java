package com.cloud.blog.context.repository.mappers;

import com.cloud.blog.context.repository.mappers.dmo.NavigationDmo;
import com.cloud.blog.context.repository.mappers.dmo.NavigationDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavigationDmoMapper {
    int countByExample(NavigationDmoExample example);

    int deleteByExample(NavigationDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(NavigationDmo record);

    int insertSelective(NavigationDmo record);

    List<NavigationDmo> selectByExample(NavigationDmoExample example);

    NavigationDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NavigationDmo record, @Param("example") NavigationDmoExample example);

    int updateByExample(@Param("record") NavigationDmo record, @Param("example") NavigationDmoExample example);

    int updateByPrimaryKeySelective(NavigationDmo record);

    int updateByPrimaryKey(NavigationDmo record);
}