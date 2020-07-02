package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.ParkingArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkingAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingArea record);

    int insertSelective(ParkingArea record);

    ParkingArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingArea record);

    int updateByPrimaryKey(ParkingArea record);

    List<ParkingArea> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

    int deleteParkingAreas(@Param("idList") Integer[] idList);

    Long selectTotal(@Param("keyWord") String keyWord);

    List<ParkingArea> selectAllParkingAreas();

}