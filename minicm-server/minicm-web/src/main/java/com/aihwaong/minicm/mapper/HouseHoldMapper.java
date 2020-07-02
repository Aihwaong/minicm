package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.HouseHold;
import org.apache.ibatis.annotations.Param;

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
 * | @date:          2020/6/29 10:34
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
public interface HouseHoldMapper {

    HouseHold selectByHouseId(@Param("houseHoldId") Integer houseHoldId, @Param("houseId") Integer houseId);

    int insertSelective(HouseHold houseHold);

}
