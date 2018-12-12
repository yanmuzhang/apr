package com.cloud.blog.context.repository.mappers;

import com.cloud.blog.context.repository.mappers.dmo.AdvertisingDmo;
import com.cloud.blog.context.repository.mappers.dmo.AdvertisingDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisingDmoMapper {
    int countByExample(AdvertisingDmoExample example);

    int deleteByExample(AdvertisingDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdvertisingDmo record);

    int insertSelective(AdvertisingDmo record);

    List<AdvertisingDmo> selectByExample(AdvertisingDmoExample example);

    AdvertisingDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdvertisingDmo record, @Param("example") AdvertisingDmoExample example);

    int updateByExample(@Param("record") AdvertisingDmo record, @Param("example") AdvertisingDmoExample example);

    int updateByPrimaryKeySelective(AdvertisingDmo record);

    int updateByPrimaryKey(AdvertisingDmo record);
}