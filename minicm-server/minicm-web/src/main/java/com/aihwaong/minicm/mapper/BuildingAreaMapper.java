package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.BuildingArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingAreaMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(BuildingArea record);


    int insertSelective(BuildingArea record);


    BuildingArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuildingArea record);

    int updateByPrimaryKey(BuildingArea record);

    int deletebuildingAreas(@Param("idList") Integer[] idList);

    Long selectTotal(@Param("keyWord") String keyWord);

    List<BuildingArea> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

    /**
     * 查询 List<BuildingArea>
     * 包括禁用、逻辑删除
     *
     * @param pid 上级id
     * @return
     */
    List<BuildingArea> getBuildingAreaUnit(Integer pid);

    /**
     * 查询 List<BuildingArea>
     * 不包括禁用、逻辑删除
     *
     * @return List<BuildingArea>
     */
    List<BuildingArea> getBuildingAreaTree();
}