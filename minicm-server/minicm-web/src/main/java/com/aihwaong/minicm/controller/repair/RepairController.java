package com.aihwaong.minicm.controller.repair;

import com.aihwaong.minicm.model.Repair;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.RepairType;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.repair
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
 * | @date:          2020/6/30 16:49
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping("/")
    public PageResponseBean<Repair> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Integer repairTypeId,
            Byte status
    ) {
        return repairService.selectAllDataOfPage(page, size, repairTypeId, status);
    }

    @GetMapping("/{id}")
    public Repair getRepair(
            @PathVariable("id") Integer id
    ) {
        return repairService.selectRepair(id);
    }

    @PutMapping("/")
    public ResponseBean updateRepair(
            @RequestBody Repair repair
    ) {
        int result = repairService.updateRepair(repair);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("处理成功");
        } else {
            return responseBean.setMessage("处理失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteRepair(
            @PathVariable("id") Integer id
    ) {
        int result = repairService.deleteRepair(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }


    /**
     * 批量修改状态
     * @param idList
     * @return
     */
    @PutMapping("/sta")
    public ResponseBean updateStautses(Byte status, Integer[] idList) {
        int result = repairService.updateStautses(status, idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("处理成功");
        } else {
            return responseBean.setMessage("处理失败");
        }
    }

    @GetMapping("/repairType")
    public List<RepairType> getRepairType() {
        return repairService.getRepairType();
    }


}
