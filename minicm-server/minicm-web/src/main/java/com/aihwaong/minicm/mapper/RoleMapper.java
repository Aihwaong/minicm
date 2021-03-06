package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_role
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_role
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_role
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_role
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_role
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_role
     *
     * @mbg.generated Wed Jun 17 17:11:04 CST 2020
     */
    int updateByPrimaryKey(Role record);

    List<Role> getPerssonelRoles(Integer id);

    List<Role> selectAllRole(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

    Long selectTotal(@Param("keyWord") String keyWord);

    int deleteRoles(@Param("idList") Integer[] idList);
}