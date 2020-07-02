package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.NoticeTypeMapper;
import com.aihwaong.minicm.model.NoticeType;
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
 * | @date:          2020/6/27 17:37
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class NoticeTypeService {

    @Autowired
    private NoticeTypeMapper noticeTypeMapper;


    public PageResponseBean<NoticeType> selectAllDataOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<NoticeType> roles = noticeTypeMapper.selectAllDataOfPage(page, size, keyWord);
        Long total = noticeTypeMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, roles);
    }

    public NoticeType selectNoticeType(Integer id) {
        return noticeTypeMapper.selectByPrimaryKey(id);
    }

    public int insertNoticeType(NoticeType noticeType) {
        noticeType.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return noticeTypeMapper.insertSelective(noticeType);
    }

    public int updateNoticeType(NoticeType noticeType) {
        return noticeTypeMapper.updateByPrimaryKeySelective(noticeType);
    }

    public int deleteNoticeType(Integer id) {
        return noticeTypeMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return noticeTypeMapper.deleteDatas(idList);
    }
}
