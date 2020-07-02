package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * | @date:          2020/6/25 23:14
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;


    public Integer[] getMenuRolesForRoleId(Integer id) {
        return menuRoleMapper.getMenuRolesForRoleId(id);
    }

    @Transactional
    public Boolean setMenuRoles(Integer rid, Integer[] mid) {
        if (mid == null || mid.length == 0) {
            return true;
        }
        // 删除该组所有权限
        if (menuRoleMapper.selectMenuRoleCount(rid) > 0) {
            menuRoleMapper.deleteMenuRoles(rid);
        }
        // 新增该组权限
        int insResult = menuRoleMapper.inserMenuRoles(rid, mid);
        if (insResult == mid.length) {
            return true;
        } else {
            return false;
        }
    }
}
