package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.PerssonelRoleMapper;
import com.aihwaong.minicm.model.PerssonelRole;
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
 * | @date:          2020/6/24 21:27
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class PersonnelRoleService {

    @Autowired
    private PerssonelRoleMapper perssonelRoleMapper;

    public List<PerssonelRole> selectAllPersonnelRoleOfPid(Integer id) {
        return perssonelRoleMapper.selectAllPersonnelRoleOfPid(id);
    }

    public int insertPersonnelRoles(Integer rid, Integer[] perssonelId) {
       return perssonelRoleMapper.insertPersonnelRoles(rid, perssonelId);
    }

    public int deletePersonnelRoles(Integer rid, Integer[] perssonelId) {
        return perssonelRoleMapper.deletePersonnelRoles(rid, perssonelId);
    }
}
