package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.HouseholdInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseholdInfoMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(HouseholdInfo record);


    int insertSelective(HouseholdInfo record);


    HouseholdInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(HouseholdInfo record);


    int updateByPrimaryKey(HouseholdInfo record);

    List<HouseholdInfo> selectAllDataOfPage(
            @Param("page") Integer page,
            @Param("size") Integer size,
            @Param("realName") String realName,
            @Param("identityDocument") String identityDocument,
            @Param("telephone") String telephone,
            @Param("nation") Byte nation
    );

    Long selectTotal(
            @Param("realName") String realName,
            @Param("identityDocument") String identityDocument,
            @Param("telephone") String telephone,
            @Param("nation") Byte nation
    );

    int deleteDatas(@Param("idList") Integer[] idList);

    List<HouseholdInfo> selectLikeNameOrPhone(@Param("keyword") String keyword);
}