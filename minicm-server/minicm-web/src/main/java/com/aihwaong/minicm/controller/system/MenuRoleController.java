package com.aihwaong.minicm.controller.system;

import com.aihwaong.minicm.model.Menu;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.MenuRoleService;
import com.aihwaong.minicm.service.MenuService;
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
 * | @date:          2020/6/25 23:13
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/authority/menuRole")
public class MenuRoleController {

    @Autowired
    private MenuRoleService menuRoleService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public List<Menu> getAllMenus(
    ) {
        return menuService.getAllMenuOfDeep();
    }

    @GetMapping("/{id}")
    public Integer[] getMenuRolesForRoleId(
            @PathVariable("id") Integer id
    ) {
        return menuRoleService.getMenuRolesForRoleId(id);
    }

    @PutMapping("/")
    public ResponseBean setMenuRoles(Integer rid, Integer[] mid) {
        Boolean result = menuRoleService.setMenuRoles(rid, mid);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result) {
            return responseBean.setMessage("设置成功");
        } else {
            return responseBean.setMessage("设置失败");
        }
    }

}
