package com.aihwaong.minicm.controller;

import com.aihwaong.minicm.model.ResponseBean;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
 * | @date:          2020/6/18 10:14
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    @Qualifier("redisTemplates")
    private RedisTemplate redisTemplate;

    @Autowired
    private Producer captchaProducer = null;

    @GetMapping("/login")
    public ResponseBean login() {
        return ResponseBean.buildResponseBean().fail("操作失败，请登录");
    }

    @GetMapping("/verify")
    @ApiOperation(value = "登录验证码")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 禁止缓存
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        // 生成验证码
        String capText = captchaProducer.createText();
        String uuid = UUID.randomUUID().toString();
        // 存入Redis
        redisTemplate.opsForValue().set(uuid, capText, 1, TimeUnit.MINUTES);
        Cookie cookie = new Cookie("captcha",uuid);

        // key写入cookie，验证时获取
        response.addCookie(cookie);
        log.info(">>>>>>>" + capText);

        // 向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
