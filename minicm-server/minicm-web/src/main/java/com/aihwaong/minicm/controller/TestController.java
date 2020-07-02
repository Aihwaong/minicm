package com.aihwaong.minicm.controller;

import com.aihwaong.minicm.mapper.MenuMapper;
import com.aihwaong.minicm.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller
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
 * | @date:          2020/6/17 17:23
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */

@RestController
public class TestController {

    @Autowired()
    private MenuMapper menuMapper;

    @RequestMapping("/")
    public Menu getMenu () {
        return menuMapper.selectByPrimaryKey(1);
    }

    @GetMapping("/perssonel/per/get")
    public String test1() {
        return "/perssonel/per/get";
    }

    @GetMapping("/perssonel/aaa/get")
    public String test2() {
        return "/perssonel/aaa/get";
    }

    @GetMapping("/test/emp/get")
    public String test3() {
        return "/test/emp/get";
    }

}
