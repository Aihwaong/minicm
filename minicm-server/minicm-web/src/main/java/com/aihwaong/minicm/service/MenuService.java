package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.MenuMapper;
import com.aihwaong.minicm.mapper.MenuRoleMapper;
import com.aihwaong.minicm.model.Menu;
import com.aihwaong.minicm.util.MenuTreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 获取当前用户可访问菜单
     *
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
     *
     * @return List<Menu>
     */
    public List<Menu> getAllMenuOfDeep() {
        MenuTreeUtils menuTreeUtils = new MenuTreeUtils(menuMapper.selectAllMenu());
        return menuTreeUtils.builTree();
    }

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    public int insertMenu(Menu menu) {
        menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return menuMapper.insertSelective(menu);
    }

    /**
     * 获取菜单
     *
     * @param id
     * @return Menu
     */
    public Menu selectMenu(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Transactional
    public Boolean deleteMenu(Integer id) {
        int mrResult = 1;

        // 获取下级菜单
        Integer[] mids = menuMapper.selectMenuIdByparentId(id);
        if (mids.length > 0) {
            // 删除下级菜单及关联权限组关联数据
            mrResult = menuMapper.deleteWithRoleByPrimaryKeys(mids);
        }

        // 删除上级菜单
        int mResult = menuMapper.deleteByPrimaryKey(id);

        return mResult > 0 && mrResult > 0;
    }
}
