package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.NoticeMapper;
import com.aihwaong.minicm.mapper.NoticeTypeMapper;
import com.aihwaong.minicm.model.Notice;
import com.aihwaong.minicm.model.NoticeType;
import com.aihwaong.minicm.model.PageResponseBean;
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
 * | @date:          2020/7/1 11:41
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeTypeMapper noticeTypeMapper;

    public PageResponseBean<Notice> selectAllDataOfPage(
            Integer page,
            Integer size,
            String title,
            Integer typeId,
            String editor,
            Date[] dates
    ) {
        page = (page - 1) * size;
        List<Notice> roles = noticeMapper.selectAllDataOfPage(page, size, title, typeId, editor, dates);
        Long total = noticeMapper.selectTotal(title, typeId, editor, dates);
        return new PageResponseBean<>(total, roles);
    }

    public Notice selectNotice(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public int insertNotice(Notice notice) {
        notice.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return noticeMapper.insertSelective(notice);
    }

    public int updateNotice(Notice notice) {
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public int deleteNotice(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return noticeMapper.deleteDatas(idList);
    }

    public List<NoticeType> getAllNoticeType() {
        return noticeTypeMapper.selectAllNoticeTypes();
    }
}
