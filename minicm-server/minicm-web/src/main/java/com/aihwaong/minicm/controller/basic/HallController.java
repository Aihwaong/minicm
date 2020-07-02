package com.aihwaong.minicm.controller.basic;

import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.Hall;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.HallService;
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
 * | @date:          2020/6/26 11:19
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/basic/hall")
public class HallController {
    
    @Autowired
    private HallService hallService;

    @GetMapping("/")
    public PageResponseBean<Hall> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return hallService.selectAllDataOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public Hall getHall(
            @PathVariable("id") Integer id
    ) {
        return hallService.selectHall(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody Hall hall
    ) {
        int result = hallService.insertHall(hall);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateHall(
            @RequestBody Hall hall
    ) {
        int result = hallService.updateHall(hall);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteHall(
            @PathVariable("id") Integer id
    ) {
        int result = hallService.deleteHall(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = hallService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }
    
}
