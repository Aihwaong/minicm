package com.aihwaong.minicm.config;

import com.aihwaong.minicm.model.Menu;
import com.aihwaong.minicm.model.Role;
import com.aihwaong.minicm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.config
 * +-------------------------------------------------------
 * | @Title:
 * +-------------------------------------------------------
 * | @ProjectName:   cm
 * +-------------------------------------------------------
 * | @Description:   用户权限决策管理器
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/20 20:46
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Component
public class PerssonelSecurityFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    /**
     * 根据用户请求的URL与菜单URL进行比较，返回菜单所对应的角色
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();  // 获取当前请求地址
        List<Menu> menuOfRole = menuService.getMenuOfRole();  // 获取所有菜单对应角色
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (Menu menu : menuOfRole) {
            // 匹配URL
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                // 获取该菜单对应角色，构建List<ConfigAttribute>
                List<Role> roles = menu.getRoles();
                String[] strRoles = new String[roles.size()];
                for (int i = 0; i < strRoles.length; i++) {
                    strRoles[i] = roles.get(i).getRoleIdentify();
                }
                return SecurityConfig.createList(strRoles);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
