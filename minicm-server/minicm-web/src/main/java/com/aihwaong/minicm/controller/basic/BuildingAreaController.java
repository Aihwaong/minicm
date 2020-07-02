package com.aihwaong.minicm.controller.basic;

import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.model.BuildingArea;
import com.aihwaong.minicm.service.BuildingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
 * | @date:          2020/6/26 10:49
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/basic/buildingArea")
public class BuildingAreaController {
    
    @Autowired
    private BuildingAreaService buildingAreaService;

    @GetMapping("/")
    public PageResponseBean<BuildingArea> selectAllDataOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return buildingAreaService.selectAllDataOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public BuildingArea getBuildingArea(
            @PathVariable("id") Integer id
    ) {
        return buildingAreaService.selectBuildingArea(id);
    }

    @GetMapping("/getUnit/{pid}")
    public List<BuildingArea> getBuildingAreaUnit(
            @PathVariable("pid") Integer pid
    ) {
        return buildingAreaService.getBuildingAreaUnit(pid);
    }


    @PostMapping("/")
    public ResponseBean insertPerssonel(
            @RequestBody BuildingArea buildingArea
    ) {
        int result = buildingAreaService.insertBuildingArea(buildingArea);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateBuildingArea(
            @RequestBody BuildingArea buildingArea
    ) {
        int result = buildingAreaService.updateBuildingArea(buildingArea);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteBuildingArea(
            @PathVariable("id") Integer id
    ) {
        int result = buildingAreaService.deleteBuildingArea(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deletebuildingAreas(Integer[] idList) {
        int result = buildingAreaService.deletebuildingAreas(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

}
