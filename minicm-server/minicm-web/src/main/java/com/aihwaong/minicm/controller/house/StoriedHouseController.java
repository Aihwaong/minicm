package com.aihwaong.minicm.controller.house;

import com.aihwaong.minicm.model.*;
import com.aihwaong.minicm.service.StoriedHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.house
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
 * | @date:          2020/6/27 21:16
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/house")
public class StoriedHouseController {

    @Autowired
    private StoriedHouseService storiedHouseService;

    @GetMapping("/")
    public PageResponseBean<StoriedHouse> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Integer ridgepole,
            Integer unit,
            Integer storey,
            String roomNumber,
            Integer chamber,
            Integer hall
    ) {
        return storiedHouseService.selectAllDataOfPage(page, size, ridgepole, unit, storey, roomNumber, chamber, hall);
    }

    @GetMapping("/{id}")
    public StoriedHouse getStoriedHouse(
            @PathVariable("id") Integer id
    ) {
        return storiedHouseService.selectStoriedHouse(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody StoriedHouse storiedHouse
    ) {
        int result = storiedHouseService.insertStoriedHouse(storiedHouse);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateStoriedHouse(
            @RequestBody StoriedHouse storiedHouse
    ) {
        int result = storiedHouseService.updateStoriedHouse(storiedHouse);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteStoriedHouse(
            @PathVariable("id") Integer id
    ) {
        int result = storiedHouseService.deleteStoriedHouse(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = storiedHouseService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @GetMapping("/getBuildingAreasTree")
    public List<BuildingArea> getBuildingAreaTree(
    ) {
        return storiedHouseService.getBuildingAreaTree();
    }

    @GetMapping("/getChambers")
    public List<Chamber> getChambers() {
        return storiedHouseService.getChambers();
    }

    @GetMapping("/getHalls")
    public List<Hall> getHalls() {
        return storiedHouseService.getHalls();
    }

}
