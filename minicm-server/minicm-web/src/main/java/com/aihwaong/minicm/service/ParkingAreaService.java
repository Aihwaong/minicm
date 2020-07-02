package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.ParkingAreaMapper;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ParkingArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.service
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
 * | @date:          2020/6/26 10:55
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class ParkingAreaService {

    @Autowired
    private ParkingAreaMapper parkingAreaMapper;

    public PageResponseBean<ParkingArea> selectAllDataOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<ParkingArea> roles = parkingAreaMapper.selectAllDataOfPage(page, size, keyWord);
        Long total = parkingAreaMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, roles);
    }

    public ParkingArea selectParkingArea(Integer id) {
        return parkingAreaMapper.selectByPrimaryKey(id);
    }

    public int insertParkingArea(ParkingArea parkingArea) {
        parkingArea.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return parkingAreaMapper.insertSelective(parkingArea);
    }

    public int updateParkingArea(ParkingArea parkingArea) {
        return parkingAreaMapper.updateByPrimaryKeySelective(parkingArea);
    }

    public int deleteParkingArea(Integer id) {
        return parkingAreaMapper.deleteByPrimaryKey(id);
    }

    public int deleteParkingAreas(Integer[] idList) {
        return parkingAreaMapper.deleteParkingAreas(idList);
    }
}
