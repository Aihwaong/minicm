package com.aihwaong.minicm.controller.basic;

import com.aihwaong.minicm.model.Chamber;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.ChamberService;
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
 * | @date:          2020/6/26 11:13
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/basic/chamber")
public class ChamberController {
    
    @Autowired
    private ChamberService chamberService;

    @GetMapping("/")
    public PageResponseBean<Chamber> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return chamberService.selectAllDataOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public Chamber getChamber(
            @PathVariable("id") Integer id
    ) {
        return chamberService.selectChamber(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody Chamber chamber
    ) {
        int result = chamberService.insertChamber(chamber);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateChamber(
            @RequestBody Chamber chamber
    ) {
        int result = chamberService.updateChamber(chamber);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteChamber(
            @PathVariable("id") Integer id
    ) {
        int result = chamberService.deleteChamber(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = chamberService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }
    
}
