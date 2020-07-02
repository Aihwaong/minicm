package com.aihwaong.minicm.controller.parking;

import com.aihwaong.minicm.model.*;
import com.aihwaong.minicm.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.parking
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
 * | @date:          2020/6/29 15:38
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/parking")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingSpaceService;

    @GetMapping("/")
    public PageResponseBean<ParkingLot> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Integer parkingAreaId,
            String number) {
        return parkingSpaceService.selectAllDataOfPage(page, size, parkingAreaId, number);
    }

    @GetMapping("/{id}")
    public ParkingLot getParkingLot(
            @PathVariable("id") Integer id
    ) {
        return parkingSpaceService.selectParkingLot(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody ParkingLot parkingSpaceRegistration
    ) {
        int result = parkingSpaceService.insertParkingLot(parkingSpaceRegistration);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateParkingLot(
            @RequestBody ParkingLot parkingSpaceRegistration
    ) {
        int result = parkingSpaceService.updateParkingLot(parkingSpaceRegistration);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteParkingLot(
            @PathVariable("id") Integer id
    ) {
        int result = parkingSpaceService.deleteParkingLot(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = parkingSpaceService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @GetMapping("/parkingAreas")
    public List<ParkingArea> getParkingAreas() {
        return parkingSpaceService.getParkingAreas();
    }

    @GetMapping("/houseHold/{id}")
    public HouseholdInfo getHouseHold(@PathVariable("id") Integer id) {
        return parkingSpaceService.getHouseHold(id);
    }

    @GetMapping("/register/{keyword}")
    public List<HouseholdInfo> selectLikeNameOrPhone(
            @PathVariable("keyword") String keyword
    ) {
        return parkingSpaceService.selectLikeNameOrPhone(keyword);
    }

    @PostMapping("/register")
    public ResponseBean registerAdd(@RequestBody ParkingSpaceRegistration parkingSpaceRegistration) {
        Boolean result = parkingSpaceService.registerAdd(parkingSpaceRegistration);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result) {
            return responseBean.setStatus(200).setMessage("登记成功");
        } else {
            return responseBean.setStatus(500).setMessage("登记失败");
        }
    }

    /**
     * 登记撤销
     * @param id parkingLotId
     * @return ResponseBean
     */
    @DeleteMapping("/register")
    public ResponseBean registerDel (@RequestParam("id") Integer id) {
        Boolean result = parkingSpaceService.registerDel(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result) {
            return responseBean.setStatus(200).setMessage("撤销成功");
        } else {
            return responseBean.setStatus(500).setMessage("撤销失败");
        }
    }
    
}
