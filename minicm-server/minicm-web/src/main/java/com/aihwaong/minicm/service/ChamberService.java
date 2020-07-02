package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.ChamberMapper;
import com.aihwaong.minicm.model.Chamber;
import com.aihwaong.minicm.model.PageResponseBean;
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
 * | @date:          2020/6/26 11:14
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class ChamberService {

    @Autowired
    private ChamberMapper chamberMapper;


    public PageResponseBean<Chamber> selectAllDataOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<Chamber> roles = chamberMapper.selectAllDataOfPage(page, size, keyWord);
        Long total = chamberMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, roles);
    }

    public Chamber selectChamber(Integer id) {
        return chamberMapper.selectByPrimaryKey(id);
    }

    public int insertChamber(Chamber chamber) {
        chamber.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return chamberMapper.insertSelective(chamber);
    }

    public int updateChamber(Chamber chamber) {
        return chamberMapper.updateByPrimaryKeySelective(chamber);
    }

    public int deleteChamber(Integer id) {
        return chamberMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return chamberMapper.deleteDatas(idList);
    }
}
