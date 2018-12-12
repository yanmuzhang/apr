package com.cloud.user.context.repository.mappers;

import com.cloud.user.context.repository.mappers.dmo.ReceiverDmo;
import com.cloud.user.context.repository.mappers.dmo.ReceiverDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiverDmoMapper {
    int countByExample(ReceiverDmoExample example);

    int deleteByExample(ReceiverDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReceiverDmo record);

    int insertSelective(ReceiverDmo record);

    List<ReceiverDmo> selectByExample(ReceiverDmoExample example);

    ReceiverDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReceiverDmo record, @Param("example") ReceiverDmoExample example);

    int updateByExample(@Param("record") ReceiverDmo record, @Param("example") ReceiverDmoExample example);

    int updateByPrimaryKeySelective(ReceiverDmo record);

    int updateByPrimaryKey(ReceiverDmo record);
}