package com.aihwaong.minicm.config;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.config
 * +-------------------------------------------------------
 * | @Title:
 * +-------------------------------------------------------
 * | @ProjectName:   vcm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/7/4 15:32
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
public class JwtConfigInfo {
    public static final String TOKEN_KEY    = "WFLZJixwR9UTzDY5js4BSutv1L8HWJzLnHeROaQ0C/5kBc=";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE   = "JWT";
    public static final String TOKEN_ISS    = "Aihwaong.com";
    public static final Integer TOKEN_EXP   = 1800 * 1000;
}
