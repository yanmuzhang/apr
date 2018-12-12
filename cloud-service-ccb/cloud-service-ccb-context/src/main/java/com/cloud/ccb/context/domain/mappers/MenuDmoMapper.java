package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.MenuDmo;
import com.cloud.ccb.context.domain.mappers.dmo.MenuDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuDmoMapper {
    int countByExample(MenuDmoExample example);

    int deleteByExample(MenuDmoExample example);

    int deleteByPrimaryKey(String id);

    int insert(MenuDmo record);

    int insertSelective(MenuDmo record);

    List<MenuDmo> selectByExample(MenuDmoExample example);

    MenuDmo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MenuDmo record, @Param("example") MenuDmoExample example);

    int updateByExample(@Param("record") MenuDmo record, @Param("example") MenuDmoExample example);

    int updateByPrimaryKeySelective(MenuDmo record);

    int updateByPrimaryKey(MenuDmo record);
}