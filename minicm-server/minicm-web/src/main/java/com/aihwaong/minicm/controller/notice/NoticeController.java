package com.aihwaong.minicm.controller.notice;

import com.aihwaong.minicm.model.Notice;
import com.aihwaong.minicm.model.NoticeType;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.notice
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
@RestController
@RequestMapping("/notice")
public class NoticeController {
    
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/")
    public PageResponseBean<Notice> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String title,
            Integer typeId,
            String editor,
            Date[] dates
    ) {
        return noticeService.selectAllDataOfPage(page, size, title, typeId, editor, dates);
    }

    @GetMapping("/{id}")
    public Notice getNotice(
            @PathVariable("id") Integer id
    ) {
        return noticeService.selectNotice(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody Notice notice
    ) {
        int result = noticeService.insertNotice(notice);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateNotice(
            @RequestBody Notice notice
    ) {
        int result = noticeService.updateNotice(notice);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteNotice(
            @PathVariable("id") Integer id
    ) {
        int result = noticeService.deleteNotice(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = noticeService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @GetMapping("/noticeType")
    public List<NoticeType> getAllNoticeType() {
        return noticeService.getAllNoticeType();
    }
    
    
}
