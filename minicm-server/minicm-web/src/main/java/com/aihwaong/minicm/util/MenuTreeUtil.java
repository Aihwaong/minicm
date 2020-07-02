package com.aihwaong.minicm.util;

import com.aihwaong.minicm.model.Menu;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.util
 * +-------------------------------------------------------
 * | @Title:         递归构建 Menu-Tree
 * +-------------------------------------------------------
 * | @ProjectName:   cm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/22 23:47
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Slf4j
public class MenuTreeUtil {
    private List<Menu> menuList;

    public MenuTreeUtil(List<Menu> menuList) {
        this.menuList = menuList;
    }

    //建立树形结构
    public List<Menu> builTree() {
        List<Menu> treeMenus = new ArrayList<>();
        for (Menu menuNode : getRootNode()) {
            treeMenus.add(buildChilTree(menuNode));
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private Menu buildChilTree(Menu pNode) {
        List<Menu> chilMenus = new ArrayList<>();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentid().equals(pNode.getId())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    //获取根节点
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists = new ArrayList<>();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentid() != null && menuNode.getParentid() == 1) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

}
