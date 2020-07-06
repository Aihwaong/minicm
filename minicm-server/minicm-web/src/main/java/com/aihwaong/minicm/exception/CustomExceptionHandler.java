package com.aihwaong.minicm.exception;

import com.aihwaong.minicm.model.ResponseBean;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.exception
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
 * | @date:          2020/7/6 22:48
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(JwtException.class)
    public ResponseBean jwtExpiredJwtException(RuntimeException e) {
        log.info(">>>>>>>>>>>??????????????");
        if (e instanceof ExpiredJwtException) {
            return ResponseBean.buildResponseBean().fail("token过期").setStatus(303);
        }
        if (e instanceof MalformedJwtException) {
            return ResponseBean.buildResponseBean().fail("无效token").setStatus(303);
        }
        return ResponseBean.buildResponseBean().fail("token出错").setStatus(302);
    }

}
