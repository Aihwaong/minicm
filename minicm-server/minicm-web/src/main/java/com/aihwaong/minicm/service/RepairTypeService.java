package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.RepairTypeMapper;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.RepairType;
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
 * | @date:          2020/6/26 11:00
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class RepairTypeService {

    @Autowired
    private RepairTypeMapper repairTypeMapper;

    public PageResponseBean<RepairType> selectAllDataOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<RepairType> roles = repairTypeMapper.selectAllDataOfPage(page, size, keyWord);
        Long total = repairTypeMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, roles);
    }

    public RepairType selectRepairType(Integer id) {
        return repairTypeMapper.selectByPrimaryKey(id);
    }

    public int insertRepairType(RepairType repairType) {
        repairType.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return repairTypeMapper.insertSelective(repairType);
    }

    public int updateRepairType(RepairType repairType) {
        return repairTypeMapper.updateByPrimaryKeySelective(repairType);
    }

    public int deleteRepairType(Integer id) {
        return repairTypeMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return repairTypeMapper.deleteDatas(idList);
    }
}
