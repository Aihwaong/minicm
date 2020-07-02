package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.BuildingAreaMapper;
import com.aihwaong.minicm.mapper.ChamberMapper;
import com.aihwaong.minicm.mapper.HallMapper;
import com.aihwaong.minicm.mapper.StoriedHouseMapper;
import com.aihwaong.minicm.model.*;
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
 * | @date:          2020/6/27 21:18
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class StoriedHouseService {

    @Autowired
    private StoriedHouseMapper storiedHouseMapper;

    @Autowired
    private BuildingAreaMapper buildingAreaMapper;

    @Autowired
    private ChamberMapper chamberMapper;

    @Autowired
    private HallMapper hallMapper;

    public PageResponseBean<StoriedHouse> selectAllDataOfPage(
            Integer page,
            Integer size,
            Integer ridgepole,
            Integer unit,
            Integer storey,
            String roomNumber,
            Integer chamber,
            Integer hall
    ) {
        page = (page - 1) * size;
        List<StoriedHouse> roles = storiedHouseMapper.selectAllDataOfPage(page, size, ridgepole, unit, storey, roomNumber, chamber, hall);
        Long total = storiedHouseMapper.selectTotal(ridgepole, unit, storey, roomNumber, chamber, hall);
        return new PageResponseBean<>(total, roles);
    }

    public StoriedHouse selectStoriedHouse(Integer id) {
        return storiedHouseMapper.selectByPrimaryKey(id);
    }

    public int insertStoriedHouse(StoriedHouse storiedHouse) {
        storiedHouse.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return storiedHouseMapper.insertSelective(storiedHouse);
    }

    public int updateStoriedHouse(StoriedHouse storiedHouse) {
        storiedHouse.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return storiedHouseMapper.updateByPrimaryKeySelective(storiedHouse);
    }

    public int deleteStoriedHouse(Integer id) {
        return storiedHouseMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return storiedHouseMapper.deleteDatas(idList);
    }

    public List<BuildingArea> getBuildingAreaTree() {
        return buildingAreaMapper.getBuildingAreaTree();
    }


    public List<Chamber> getChambers() {
        return chamberMapper.getChambers();
    }

    public List<Hall> getHalls() {
        return hallMapper.getHalls();
    }
}
