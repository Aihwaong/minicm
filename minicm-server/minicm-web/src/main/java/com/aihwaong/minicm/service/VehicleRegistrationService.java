package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.HouseholdInfoMapper;
import com.aihwaong.minicm.mapper.VehicleRegistrationMapper;
import com.aihwaong.minicm.model.HouseholdInfo;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.VehicleRegistration;
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
 * | @date:          2020/6/30 12:40
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class VehicleRegistrationService {

    @Autowired
    private VehicleRegistrationMapper vehicleRegistrationMapper;

    @Autowired
    private HouseholdInfoMapper householdInfoMapper;


    public PageResponseBean<VehicleRegistration> selectAllDataOfPage(Integer page, Integer size, Integer plateNumber, String external) {
        page = (page - 1) * size;
        List<VehicleRegistration> roles = vehicleRegistrationMapper.selectAllDataOfPage(page, size, plateNumber, external);
        Long total = vehicleRegistrationMapper.selectTotal(plateNumber, external);
        return new PageResponseBean<>(total, roles);
    }

    public VehicleRegistration selectVehicleRegistration(Integer id) {
        return vehicleRegistrationMapper.selectByPrimaryKey(id);
    }

    public int insertVehicleRegistration(VehicleRegistration vehicleRegistration) {
        vehicleRegistration.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return vehicleRegistrationMapper.insertSelective(vehicleRegistration);
    }

    public int updateVehicleRegistration(VehicleRegistration vehicleRegistration) {
        return vehicleRegistrationMapper.updateByPrimaryKeySelective(vehicleRegistration);
    }

    public int deleteVehicleRegistration(Integer id) {
        return vehicleRegistrationMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return vehicleRegistrationMapper.deleteDatas(idList);
    }

    public List<HouseholdInfo> getHouseHolds(String keyword) {
        return householdInfoMapper.selectLikeNameOrPhone(keyword);
    }
}
