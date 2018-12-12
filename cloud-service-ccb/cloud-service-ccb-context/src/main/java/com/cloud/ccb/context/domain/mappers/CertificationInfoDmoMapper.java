package com.cloud.ccb.context.domain.mappers;

import com.cloud.ccb.context.domain.mappers.dmo.CertificationInfoDmo;
import com.cloud.ccb.context.domain.mappers.dmo.CertificationInfoDmoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertificationInfoDmoMapper {
    int countByExample(CertificationInfoDmoExample example);

    int deleteByExample(CertificationInfoDmoExample example);

    int deleteByPrimaryKey(String idCardNumber);

    int insert(CertificationInfoDmo record);

    int insertSelective(CertificationInfoDmo record);

    List<CertificationInfoDmo> selectByExample(CertificationInfoDmoExample example);

    CertificationInfoDmo selectByPrimaryKey(String idCardNumber);

    int updateByExampleSelective(@Param("record") CertificationInfoDmo record, @Param("example") CertificationInfoDmoExample example);

    int updateByExample(@Param("record") CertificationInfoDmo record, @Param("example") CertificationInfoDmoExample example);

    int updateByPrimaryKeySelective(CertificationInfoDmo record);

    int updateByPrimaryKey(CertificationInfoDmo record);
}