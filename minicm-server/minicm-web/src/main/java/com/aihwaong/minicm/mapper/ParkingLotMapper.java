package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.ParkingLot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.mapper
 * +-------------------------------------------------------
 * | @Title:
 * +-------------------------------------------------------
 * | @ProjectName:   cm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/29 16:05
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
public interface ParkingLotMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ParkingLot record);

    int insertSelective(ParkingLot record);

    ParkingLot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingLot record);

    int updateByPrimaryKey(ParkingLot record);

    List<ParkingLot> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("parkingAreaId") Integer parkingAreaId, @Param("number") String number);

    Long selectTotal(@Param("parkingAreaId") Integer parkingAreaId, @Param("number") String number);

    int deleteDatas(@Param("idList") Integer[] idList);
}
