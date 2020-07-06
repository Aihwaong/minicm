package com.aihwaong.minicm.controller.system;

import com.aihwaong.minicm.model.Menu;
import com.aihwaong.minicm.model.ResponseBean;
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
 * | @Title:         系统管理 — 菜单管理
 * +-------------------------------------------------------
 * | @ProjectName:   cm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/23 9:47
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/menu")
public class SystemMenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/getMenuList")
    public List<Menu> getAllMenu() {
        return menuService.getAllMenuOfDeep();
    }

    @GetMapping("/{id}")
    public Menu getMenu(
            @PathVariable("id") Integer id
    ) {
        return menuService.selectMenu(id);
    }

    @PostMapping("/")
    public ResponseBean insertMenu(
            @RequestBody Menu menu
    ) {
        int result = menuService.insertMenu(menu);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updateMenu(
            @RequestBody Menu menu
    ) {
        int result = menuService.updateMenu(menu);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteMenu(
            @PathVariable("id") Integer id
    ) {
        Boolean result = menuService.deleteMenu(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

}
