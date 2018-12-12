package com.cloud.blog.context.repository.mappers;

import com.cloud.blog.context.repository.mappers.dmo.TopicDmo;
import com.cloud.blog.context.repository.mappers.dmo.TopicDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicDmoMapper {
    int countByExample(TopicDmoExample example);

    int deleteByExample(TopicDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TopicDmo record);

    int insertSelective(TopicDmo record);

    List<TopicDmo> selectByExample(TopicDmoExample example);

    TopicDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TopicDmo record, @Param("example") TopicDmoExample example);

    int updateByExample(@Param("record") TopicDmo record, @Param("example") TopicDmoExample example);

    int updateByPrimaryKeySelective(TopicDmo record);

    int updateByPrimaryKey(TopicDmo record);
}