package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Hall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Hall record);

    int insertSelective(Hall record);

    Hall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hall record);

    int updateByPrimaryKey(Hall record);

    List<Hall> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

    Long selectTotal(@Param("keyWord") String keyWord);

    int deleteDatas(@Param("idList") Integer[] idList);

    List<Hall> getHalls();
}