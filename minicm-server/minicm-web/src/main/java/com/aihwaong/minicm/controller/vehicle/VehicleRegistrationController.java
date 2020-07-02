package com.aihwaong.minicm.controller.vehicle;

import com.aihwaong.minicm.model.HouseholdInfo;
import com.aihwaong.minicm.model.VehicleRegistration;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.VehicleRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.vehicle
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
 * | @date:          2020/6/30 12:40
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleRegistrationController {

    @Autowired
    private VehicleRegistrationService vehicleRegistrationService;

    @GetMapping("/")
    public PageResponseBean<VehicleRegistration> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Integer plateNumber,
            String external
    ) {
        return vehicleRegistrationService.selectAllDataOfPage(page, size, plateNumber, external);
    }

    @GetMapping("/{id}")
    public VehicleRegistration getVehicleRegistration(
            @PathVariable("id") Integer id
    ) {
        return vehicleRegistrationService.selectVehicleRegistration(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody VehicleRegistration vehicleRegistration
    ) {
        int result = vehicleRegistrationService.insertVehicleRegistration(vehicleRegistration);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateVehicleRegistration(
            @RequestBody VehicleRegistration vehicleRegistration
    ) {
        int result = vehicleRegistrationService.updateVehicleRegistration(vehicleRegistration);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteVehicleRegistration(
            @PathVariable("id") Integer id
    ) {
        int result = vehicleRegistrationService.deleteVehicleRegistration(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = vehicleRegistrationService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @GetMapping("/houseHolds")
    public List<HouseholdInfo> getHouseHolds(String keyword) {
        return vehicleRegistrationService.getHouseHolds(keyword);
    }


}
