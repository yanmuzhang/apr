package com.cloud.ccb.context.domain.query;

import com.cloud.ccb.context.domain.model.OperatorAttr;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface AttrQuery {


    Set<OperatorAttr> getAppAttrByAppId(@Param("appId") String appId);

    Set<OperatorAttr> getUserAttrByOperatorId(@Param("operatorId") String operatorId);

    int deleteUserAttrByOperatorId(@Param("operatorId") String operatorId);
}
