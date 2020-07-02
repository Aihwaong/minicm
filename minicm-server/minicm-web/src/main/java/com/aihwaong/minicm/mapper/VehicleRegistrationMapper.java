package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.VehicleRegistration;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleRegistrationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleRegistration record);

    int insertSelective(VehicleRegistration record);

    VehicleRegistration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VehicleRegistration record);

    int updateByPrimaryKey(VehicleRegistration record);

    List<VehicleRegistration> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("plateNumber") Integer plateNumber, @Param("external") String external);

    Long selectTotal(@Param("plateNumber") Integer plateNumber, @Param("external") String external);

    int deleteDatas(@Param("idList") Integer[] idList);
}