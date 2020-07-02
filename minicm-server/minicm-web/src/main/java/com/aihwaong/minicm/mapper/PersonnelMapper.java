package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Personnel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonnelMapper {
   
    int deleteByPrimaryKey(Integer id);

    int insert(Personnel record);

    int insertSelective(Personnel record);

    Personnel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Personnel record);

    int updateByPrimaryKey(Personnel record);

    Personnel loadUserAccount(String account);

    List<Personnel> getAllPerssonelOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

     Long selectTotal(@Param("keyWord") String keyWord);

    List<Personnel> getAllPerssonel();

    int deletePersonnels(Integer[] idList);
}