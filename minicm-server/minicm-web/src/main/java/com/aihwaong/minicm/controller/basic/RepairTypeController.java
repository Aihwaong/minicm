package com.aihwaong.minicm.controller.basic;

import com.aihwaong.minicm.model.RepairType;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.RepairTypeService;
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
 * | @date:          2020/6/26 11:00
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/basic/repairType")
public class RepairTypeController {
    
    @Autowired
    private RepairTypeService repairTypeService;

    @GetMapping("/")
    public PageResponseBean<RepairType> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return repairTypeService.selectAllDataOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public RepairType getRepairType(
            @PathVariable("id") Integer id
    ) {
        return repairTypeService.selectRepairType(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody RepairType repairType
    ) {
        int result = repairTypeService.insertRepairType(repairType);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateRepairType(
            @RequestBody RepairType repairType
    ) {
        int result = repairTypeService.updateRepairType(repairType);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteRepairType(
            @PathVariable("id") Integer id
    ) {
        int result = repairTypeService.deleteRepairType(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }


    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = repairTypeService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }
}
