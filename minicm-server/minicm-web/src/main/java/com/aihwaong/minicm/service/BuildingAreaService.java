package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.BuildingAreaMapper;
import com.aihwaong.minicm.model.BuildingArea;
import com.aihwaong.minicm.model.PageResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.service
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
 * | @date:          2020/6/26 10:50
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class BuildingAreaService {

    @Autowired
    private BuildingAreaMapper buildingAreaMapper;

    public PageResponseBean<BuildingArea> selectAllDataOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<BuildingArea> buildingAreas = buildingAreaMapper.selectAllDataOfPage(page, size, keyWord);
        Long total = buildingAreaMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, buildingAreas);
    }

    public BuildingArea selectBuildingArea(Integer id) {
        return buildingAreaMapper.selectByPrimaryKey(id);
    }

    public int insertBuildingArea(BuildingArea buildingArea) {
        buildingArea.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return buildingAreaMapper.insertSelective(buildingArea);
    }

    public int updateBuildingArea(BuildingArea buildingArea) {
        return buildingAreaMapper.updateByPrimaryKeySelective(buildingArea);
    }

    public int deleteBuildingArea(Integer id) {
        return buildingAreaMapper.deleteByPrimaryKey(id);
    }

    public int deletebuildingAreas(Integer[] idList) {
        return buildingAreaMapper.deletebuildingAreas(idList);
    }

    public List<BuildingArea> getBuildingAreaUnit(Integer pid) {
        return buildingAreaMapper.getBuildingAreaUnit(pid);
    }
}
