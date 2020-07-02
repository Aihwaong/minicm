package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.HallMapper;
import com.aihwaong.minicm.model.Hall;
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
 * | @date:          2020/6/26 11:19
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class HallService {

    @Autowired
    private HallMapper hallMapper;

    public PageResponseBean<Hall> selectAllDataOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<Hall> roles = hallMapper.selectAllDataOfPage(page, size, keyWord);
        Long total = hallMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, roles);
    }

    public Hall selectHall(Integer id) {
        return hallMapper.selectByPrimaryKey(id);
    }

    public int insertHall(Hall hall) {
        hall.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return hallMapper.insertSelective(hall);
    }

    public int updateHall(Hall hall) {
        return hallMapper.updateByPrimaryKeySelective(hall);
    }

    public int deleteHall(Integer id) {
        return hallMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return hallMapper.deleteDatas(idList);
    }
}
