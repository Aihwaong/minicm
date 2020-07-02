package com.aihwaong.minicm.controller.system;

import com.aihwaong.minicm.model.PerssonelRole;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.PersonnelRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.system
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
 * | @date:          2020/6/24 21:28
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/authority/personnelRole")
@Slf4j
public class PerssonelRoleController {

    @Autowired
    private PersonnelRoleService personnelRoleService;

    @GetMapping("/{id}")
    public List<PerssonelRole> getAllPersonnelRole(
            @PathVariable("id") Integer id
    ) {
        return personnelRoleService.selectAllPersonnelRoleOfPid(id);
    }

    @PutMapping("/")
    public ResponseBean insertPersonnelRoles (Integer rid, Integer[] perssonelId) {
        int result = personnelRoleService.insertPersonnelRoles(rid, perssonelId);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("添加成功");
        } else {
            return responseBean.setMessage("添加失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deletePersonnelRoles (Integer rid, Integer[] perssonelId) {
        int result = personnelRoleService.deletePersonnelRoles(rid, perssonelId);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("移除成功");
        } else {
            return responseBean.setMessage("移除失败");
        }
    }
}
