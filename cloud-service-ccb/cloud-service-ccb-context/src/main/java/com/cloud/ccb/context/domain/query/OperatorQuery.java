package com.cloud.ccb.context.domain.query;

import cn.liberfree.common.Page;
import cn.liberfree.mybatis.PageParames;
import org.apache.ibatis.annotations.Param;

public interface OperatorQuery {

    String getPeopleIdByAppIdAndOpenId(@Param("appId")String appId, @Param("openId")String openId);

    boolean existByAppIdAndPeopleId(@Param("appId")String appId,@Param("peopleId") String peopleId);

    String getPeopleIdByPhone(@Param("phone") String phone);

    String getOpenIdByPeopleIdAndAppId(@Param("peopleId")String peopleId, @Param("appId")String appId);

    Page<String> list(PageParames pageParames);
}
