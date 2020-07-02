package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.VisitorMapper;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
 * | @date:          2020/6/30 23:14
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;

    public PageResponseBean<Visitor> selectAllDataOfPage(Integer page, Integer size, String realName, String telephone, Date[] dates) {
        page = (page - 1) * size;
        List<Visitor> roles = visitorMapper.selectAllDataOfPage(page, size, realName, telephone, dates);
        Long total = visitorMapper.selectTotal(realName, telephone, dates);
        return new PageResponseBean<>(total, roles);
    }

    public Visitor selectVisitor(Integer id) {
        return visitorMapper.selectByPrimaryKey(id);
    }

    public int insertVisitor(Visitor visitor) {
        visitor.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return visitorMapper.insertSelective(visitor);
    }

    public int updateVisitor(Visitor visitor) {
        return visitorMapper.updateByPrimaryKeySelective(visitor);
    }

    public int deleteVisitor(Integer id) {
        return visitorMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return visitorMapper.deleteDatas(idList);
    }
}
