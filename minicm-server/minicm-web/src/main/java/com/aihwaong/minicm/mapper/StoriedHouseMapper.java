package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.BuildingArea;
import com.aihwaong.minicm.model.StoriedHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoriedHouseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(StoriedHouse record);

    int insertSelective(StoriedHouse record);

    StoriedHouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StoriedHouse record);

    int updateByPrimaryKey(StoriedHouse record);

    List<StoriedHouse> selectAllDataOfPage(
            @Param("page") Integer page,
            @Param("size") Integer size,
            @Param("ridgepole") Integer ridgepole,
            @Param("unit") Integer unit,
            @Param("storey") Integer storey,
            @Param("roomNumber") String roomNumber,
            @Param("chamber") Integer chamber,
            @Param("hall") Integer hall
    );

    Long selectTotal(
            @Param("ridgepole") Integer ridgepole,
            @Param("unit") Integer unit,
            @Param("storey") Integer storey,
            @Param("roomNumber") String roomNumber,
            @Param("chamber") Integer chamber,
            @Param("hall") Integer hall
    );

    int deleteDatas(@Param("idList") Integer[] idList);

    List<BuildingArea> getHouses(@Param("ridgepole") Integer ridgepole, @Param("unit") Integer unit);

    List<StoriedHouse> selectCheckInByHouseHoldId(@Param("household") Integer household);
}