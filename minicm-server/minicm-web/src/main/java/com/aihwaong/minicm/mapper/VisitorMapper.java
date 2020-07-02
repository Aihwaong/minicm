package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface VisitorMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    List<Visitor> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("realName") String realName, @Param("telephone") String telephone, @Param("dates")Date[] dates);

    Long selectTotal(@Param("realName") String realName, @Param("telephone") String telephone, @Param("dates")Date[] dates);

    int deleteDatas(@Param("idList") Integer[] idList);
}