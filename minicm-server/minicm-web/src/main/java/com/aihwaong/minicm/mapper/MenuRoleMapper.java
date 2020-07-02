package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.MenuRole;
import org.apache.ibatis.annotations.Param;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    Integer[] getMenuRolesForRoleId(@Param("rid") Integer rid);

    int deleteMenuRoles(Integer rid);

    int inserMenuRoles(Integer rid, Integer[] mid);

    int selectMenuRoleCount(Integer rid);
}