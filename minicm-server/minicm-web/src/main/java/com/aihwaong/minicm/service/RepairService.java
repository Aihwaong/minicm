package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.RepairMapper;
import com.aihwaong.minicm.mapper.RepairTypeMapper;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.Repair;
import com.aihwaong.minicm.model.RepairType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * | @date:          2020/6/30 16:50
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    private RepairTypeMapper repairTypeMapper;

    public PageResponseBean<Repair> selectAllDataOfPage(Integer page, Integer size, Integer repairTypeId, Byte status) {
        page = (page - 1) * size;
        List<Repair> roles = repairMapper.selectAllDataOfPage(page, size, repairTypeId, status);
        Long total = repairMapper.selectTotal(repairTypeId, status);
        return new PageResponseBean<>(total, roles);
    }

    public Repair selectRepair(Integer id) {
        return repairMapper.selectById(id);
    }

    public int updateRepair(Repair repair) {
        return repairMapper.updateByPrimaryKeySelective(repair);
    }

    public int deleteRepair(Integer id) {
        return repairMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return repairMapper.deleteDatas(idList);
    }

    public int updateStautses(Byte status, Integer[] idList) {
        return repairMapper.updateStautses(status, idList);
    }

    public List<RepairType> getRepairType() {
        return repairTypeMapper.selectAllRepairTypes();
    }
}
