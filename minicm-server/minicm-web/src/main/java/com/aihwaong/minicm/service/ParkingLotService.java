package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.HouseholdInfoMapper;
import com.aihwaong.minicm.mapper.ParkingAreaMapper;
import com.aihwaong.minicm.mapper.ParkingLotMapper;
import com.aihwaong.minicm.mapper.ParkingSpaceRegistrationMapper;
import com.aihwaong.minicm.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * | @date:          2020/6/29 15:38
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
@Slf4j
public class ParkingLotService {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    private ParkingAreaMapper parkingAreaMapper;

    @Autowired
    private HouseholdInfoMapper householdInfoMapper;

    @Autowired
    private ParkingSpaceRegistrationMapper parkingSpaceRegistrationMapper;

    public PageResponseBean<ParkingLot> selectAllDataOfPage(Integer page, Integer size, Integer parkingAreaId, String number) {
        page = (page - 1) * size;
        List<ParkingLot> roles = parkingLotMapper.selectAllDataOfPage(page, size, parkingAreaId, number);
        Long total = parkingLotMapper.selectTotal(parkingAreaId, number);
        return new PageResponseBean<>(total, roles);
    }

    public ParkingLot selectParkingLot(Integer id) {
        return parkingLotMapper.selectByPrimaryKey(id);
    }

    public int insertParkingLot(ParkingLot parkingLot) {
        parkingLot.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return parkingLotMapper.insertSelective(parkingLot);
    }

    public int updateParkingLot(ParkingLot parkingLot) {
        parkingLot.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return parkingLotMapper.updateByPrimaryKeySelective(parkingLot);
    }

    public int deleteParkingLot(Integer id) {
        return parkingLotMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return parkingLotMapper.deleteDatas(idList);
    }

    public List<ParkingArea> getParkingAreas() {
        return parkingAreaMapper.selectAllParkingAreas();
    }

    public List<HouseholdInfo> selectLikeNameOrPhone(String keyword) {
        return householdInfoMapper.selectLikeNameOrPhone(keyword);
    }

    @Transactional
    public Boolean registerAdd(ParkingSpaceRegistration parkingSpaceRegistration) {
        // 新增登记记录
        parkingSpaceRegistration.setCreateTime(new Timestamp(System.currentTimeMillis()));
        int psResult = parkingSpaceRegistrationMapper.insertSelective(parkingSpaceRegistration);
        // 改变车位状态
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(parkingSpaceRegistration.getParkingLotId());
        Byte business = parkingSpaceRegistration.getRegisterWay().equals("0") ? Byte.parseByte("2") : Byte.parseByte("3");
        parkingLot.setBusiness(business);
        int plResult = parkingLotMapper.updateByPrimaryKeySelective(parkingLot);
        return psResult > 0 && plResult > 0;
    }

    public HouseholdInfo getHouseHold(Integer id) {
        // 查询登记记录
        ParkingSpaceRegistration parkingSpaceRegistration = parkingSpaceRegistrationMapper.selectByParkingLotId(id);
        // 查询业主信息
        return householdInfoMapper.selectByPrimaryKey(parkingSpaceRegistration.getHouseholdId());
    }

    public Boolean registerDel(Integer id) {
        // 修改登记状态
        ParkingSpaceRegistration parkingSpaceRegistration = new ParkingSpaceRegistration();
        parkingSpaceRegistration.setParkingLotId(id);
        int psResult = parkingSpaceRegistrationMapper.updateStatusByParkingLotId(parkingSpaceRegistration);
        // 修改车位状态
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(id);
        parkingLot.setBusiness(Byte.parseByte("1"));
        int plResult = parkingLotMapper.updateByPrimaryKeySelective(parkingLot);
        return psResult > 0 && plResult > 0;
    }
}
