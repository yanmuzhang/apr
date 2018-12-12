package com.cloud.blog.context.repository.mappers;

import com.cloud.blog.context.repository.mappers.dmo.TopicTypeDmo;
import com.cloud.blog.context.repository.mappers.dmo.TopicTypeDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicTypeDmoMapper {
    int countByExample(TopicTypeDmoExample example);

    int deleteByExample(TopicTypeDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TopicTypeDmo record);

    int insertSelective(TopicTypeDmo record);

    List<TopicTypeDmo> selectByExample(TopicTypeDmoExample example);

    TopicTypeDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TopicTypeDmo record, @Param("example") TopicTypeDmoExample example);

    int updateByExample(@Param("record") TopicTypeDmo record, @Param("example") TopicTypeDmoExample example);

    int updateByPrimaryKeySelective(TopicTypeDmo record);

    int updateByPrimaryKey(TopicTypeDmo record);
}