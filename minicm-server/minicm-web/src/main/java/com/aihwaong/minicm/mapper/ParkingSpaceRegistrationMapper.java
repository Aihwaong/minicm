package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.ParkingSpaceRegistration;

public interface ParkingSpaceRegistrationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingSpaceRegistration record);

    int insertSelective(ParkingSpaceRegistration record);

    ParkingSpaceRegistration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingSpaceRegistration record);

    int updateByPrimaryKey(ParkingSpaceRegistration record);

    ParkingSpaceRegistration selectByParkingLotId(Integer id);

    int updateStatusByParkingLotId(ParkingSpaceRegistration parkingSpaceRegistration);
}