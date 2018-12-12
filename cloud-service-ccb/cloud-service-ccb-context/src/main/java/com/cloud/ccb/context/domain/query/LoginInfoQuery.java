package com.cloud.ccb.context.domain.query;

import com.cloud.ccb.context.domain.mappers.dmo.LoginInfoDmo;
import org.apache.ibatis.annotations.Param;

public interface LoginInfoQuery {

    LoginInfoDmo getLoginInfoByPeopleIdAndSource(@Param("peopleId") String peopleId, @Param("source")String source);
}
