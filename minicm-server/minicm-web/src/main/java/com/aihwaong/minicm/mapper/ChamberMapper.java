package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Chamber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChamberMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Chamber record);


    int insertSelective(Chamber record);


    Chamber selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Chamber record);


    int updateByPrimaryKey(Chamber record);

    List<Chamber> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

    Long selectTotal(@Param("keyWord") String keyWord);

    int deleteDatas(@Param("idList") Integer[] idList);

    List<Chamber> getChambers();
}