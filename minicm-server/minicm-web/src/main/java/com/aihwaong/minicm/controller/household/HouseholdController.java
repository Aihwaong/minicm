package com.aihwaong.minicm.controller.household;

import com.aihwaong.minicm.model.*;
import com.aihwaong.minicm.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.household
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
 * | @date:          2020/6/28 15:50
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/household")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping("/")
    public PageResponseBean<HouseholdInfo> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String realName,
            String identityDocument,
            String telephone,
            Byte nation
    ) {
        return householdService.selectAllDataOfPage(page, size, realName, identityDocument, telephone, nation);
    }

    @GetMapping("/{id}")
    public HouseholdInfo getHouseholdInfo(
            @PathVariable("id") Integer id
    ) {
        return householdService.selectHouseholdInfo(id);
    }

    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody HouseholdInfo householdInfo
    ) {
        Boolean result = householdService.insertHouseholdInfo(householdInfo);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateHouseholdInfo(
            @RequestBody HouseholdInfo householdInfo
    ) {
        int result = householdService.updateHouseholdInfo(householdInfo);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteHouseholdInfo(
            @PathVariable("id") Integer id
    ) {
        int result = householdService.deleteHouseholdInfo(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deleteDatas(Integer[] idList) {
        int result = householdService.deleteDatas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @GetMapping("/getNations")
    public List<Nation> getAllNation() {
        return householdService.selectAllNation();
    }

    @GetMapping("/getHouses")
    public List<BuildingArea> getHouses (
            @RequestParam("ridgepole") Integer ridgepole,
            @RequestParam("unit") Integer unit
    ) {
        return householdService.getHouses(ridgepole, unit);
    }

    /**
     * 获取住户已登记房屋
     * @param household 住户ID
     * @return List<StoriedHouse>
     */
    @GetMapping("/house/getCheckInHouse/{household}")
    public List<StoriedHouse> getCheckInHouse (
            @PathVariable("household") Integer household
    ) {
        return householdService.selectCheckInByHouseHoldId(household);
    }

    /**
     * 住户入住登记
     * @param houseHold 登记记录
     * @return ResponseBean
     */
    @PostMapping("/checkIn")
    public ResponseBean checkIn (@RequestBody  HouseHold houseHold) {
        int result = householdService.checkIn(houseHold);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("登记成功").setStatus(200);
        } else {
            return responseBean.setMessage("重复登记").setStatus(500);
        }
    }

}
