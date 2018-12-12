package com.cloud.system.context.repository.mappers;

import com.cloud.system.context.repository.mappers.dmo.GroupDmo;
import com.cloud.system.context.repository.mappers.dmo.GroupDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupDmoMapper {
    int countByExample(GroupDmoExample example);

    int deleteByExample(GroupDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(GroupDmo record);

    int insertSelective(GroupDmo record);

    List<GroupDmo> selectByExample(GroupDmoExample example);

    GroupDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GroupDmo record, @Param("example") GroupDmoExample example);

    int updateByExample(@Param("record") GroupDmo record, @Param("example") GroupDmoExample example);

    int updateByPrimaryKeySelective(GroupDmo record);

    int updateByPrimaryKey(GroupDmo record);
}