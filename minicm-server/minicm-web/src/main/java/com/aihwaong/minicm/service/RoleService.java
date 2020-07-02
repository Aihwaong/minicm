package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.RoleMapper;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * | @date:          2020/6/24 15:09
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public PageResponseBean<Role> getAllRole(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<Role> roles = roleMapper.selectAllRole(page, size, keyWord);
        Long total = roleMapper.selectTotal(keyWord);
        return new PageResponseBean<>(total, roles);
    }

    public Role selectRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public int insertRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    public int deleteRole(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    public int deleteRoles(Integer[] idList) {
        return roleMapper.deleteRoles(idList);
    }
}
