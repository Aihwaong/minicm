package com.aihwaong.minicm.controller.basic;

import com.aihwaong.minicm.model.NoticeType;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.NoticeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.basic
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
 * | @date:          2020/6/27 17:36
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/basic/noticeType")
public class NoticeTypeController {

    @Autowired
    private NoticeTypeService noticeTypeService;

    @GetMapping("/")
    public PageResponseBean<NoticeType> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return noticeTypeService.selectAllDataOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public NoticeType getNoticeType(
            @PathVariable("id") Integer id
    ) {
        return noticeTypeService.selectNoticeType(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody NoticeType noticeType
    ) {
        int result = noticeTypeService.insertNoticeType(noticeType);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateNoticeType(
            @RequestBody NoticeType noticeType
    ) {
        int result = noticeTypeService.updateNoticeType(noticeType);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteNoticeType(
            @PathVariable("id") Integer id
    ) {
        int result = noticeTypeService.deleteNoticeType(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = noticeTypeService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }
    
}
