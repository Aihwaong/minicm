package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.PerssonelRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PerssonelRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PerssonelRole record);

    int insertSelective(PerssonelRole record);

    PerssonelRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PerssonelRole record);

    int updateByPrimaryKey(PerssonelRole record);

    List<PerssonelRole> selectAllPersonnelRoleOfPid(Integer id);

    int insertPersonnelRoles(@Param("rid") Integer rid, @Param("perssonelId") Integer[] perssonelId);

    int deletePersonnelRoles(@Param("rid") Integer rid, @Param("perssonelId") Integer[] perssonelId);
}