package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.MenuMapper;
import com.aihwaong.minicm.model.Menu;
import com.aihwaong.minicm.util.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
 * | @date:          2020/6/19 9:33
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取当前用户可访问菜单
     * @param perssonelId 用户id
     * @return
     */
    public List<Menu> getMenu(Integer perssonelId) {
        return menuMapper.getMenuByPerssonelId(perssonelId);
    }


    public List<Menu> getMenuOfRole() {
        return menuMapper.getMenuOfRole();
    }

    /**
     * 获取菜单Tree
     * @return List<Menu>
     */
    public List<Menu> getAllMenuOfDeep() {
        MenuTreeUtil menuTreeUtil = new MenuTreeUtil(menuMapper.selectAllMenu());
        return menuTreeUtil.builTree();
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    public int insertMenu(Menu menu) {
        menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return menuMapper.insertSelective(menu);
    }

    /**
     * 获取菜单
     * @param id
     * @return Menu
     */
    public Menu selectMenu(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    public int deleteMenu(Integer id) {

        return menuMapper.deleteByPrimaryKey(id);
    }
}
