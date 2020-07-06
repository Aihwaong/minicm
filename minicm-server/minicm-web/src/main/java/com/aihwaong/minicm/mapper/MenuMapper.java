package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenuByPerssonelId(Integer perssonelId);

    List<Menu> getMenuOfRole();

    List<Menu> selectAllMenu();

    Integer[] selectMenuIdByparentId(Integer id);

    int deleteWithRoleByPrimaryKeys(@Param("ids") Integer[] ids);
}