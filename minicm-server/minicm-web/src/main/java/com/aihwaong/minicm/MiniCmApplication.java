package com.aihwaong.minicm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong
 * +-------------------------------------------------------
 * | @Title:
 * +-------------------------------------------------------
 * | @ProjectName:   minicm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/15 22:30
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.aihwaong.minicm.mapper"})
public class MiniCmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniCmApplication.class, args);
    }

}
