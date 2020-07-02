package com.aihwaong.minicm.controller.basic;

import com.aihwaong.minicm.model.ParkingArea;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.ParkingAreaService;
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
 * | @date:          2020/6/26 10:55
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/basic/parkingArea")
public class ParkingAreaController {
    
    @Autowired
    private ParkingAreaService parkingAreaService;

    @GetMapping("/")
    public PageResponseBean<ParkingArea> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return parkingAreaService.selectAllDataOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public ParkingArea getParkingArea(
            @PathVariable("id") Integer id
    ) {
        return parkingAreaService.selectParkingArea(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody ParkingArea parkingArea
    ) {
        int result = parkingAreaService.insertParkingArea(parkingArea);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateParkingArea(
            @RequestBody ParkingArea parkingArea
    ) {
        int result = parkingAreaService.updateParkingArea(parkingArea);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteParkingArea(
            @PathVariable("id") Integer id
    ) {
        int result = parkingAreaService.deleteParkingArea(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteParkingAreas(Integer[] idList) {
        int result = parkingAreaService.deleteParkingAreas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }
    
}
