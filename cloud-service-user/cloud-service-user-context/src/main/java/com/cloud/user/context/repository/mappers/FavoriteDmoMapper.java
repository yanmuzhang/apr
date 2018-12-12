package com.cloud.user.context.repository.mappers;

import com.cloud.user.context.repository.mappers.dmo.FavoriteDmo;
import com.cloud.user.context.repository.mappers.dmo.FavoriteDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoriteDmoMapper {
    int countByExample(FavoriteDmoExample example);

    int deleteByExample(FavoriteDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(FavoriteDmo record);

    int insertSelective(FavoriteDmo record);

    List<FavoriteDmo> selectByExample(FavoriteDmoExample example);

    FavoriteDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FavoriteDmo record, @Param("example") FavoriteDmoExample example);

    int updateByExample(@Param("record") FavoriteDmo record, @Param("example") FavoriteDmoExample example);

    int updateByPrimaryKeySelective(FavoriteDmo record);

    int updateByPrimaryKey(FavoriteDmo record);
}