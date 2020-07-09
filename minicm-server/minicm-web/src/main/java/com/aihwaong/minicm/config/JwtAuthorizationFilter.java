package com.aihwaong.minicm.config;

import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.config
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
 * | @date:          2020/7/4 16:04
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private RedisTemplate<String, Object> redisTemplate;


    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, RedisTemplate<String, Object> redisTemplate) {
        super(authenticationManager);
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(JwtConfigInfo.TOKEN_HEADER);
        if (!StringUtils.isEmpty(token) && token.startsWith(JwtConfigInfo.TOKEN_PREFIX)) {
            try {
                Jws<Claims> paresToken = Jwts.parserBuilder()
                        .setSigningKey(JwtConfigInfo.TOKEN_KEY.getBytes())
                        .build()
                        .parseClaimsJws(token.replace(JwtConfigInfo.TOKEN_PREFIX, " "));

                List<SimpleGrantedAuthority> authorities = ((List<?>) paresToken.getBody().get("roles")).stream()
                        .map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());

                String username = paresToken.getBody().getSubject();
                if (!StringUtils.isEmpty(username)) {
                    return new UsernamePasswordAuthenticationToken(username, null, authorities);
                }
            } catch (ExpiredJwtException e) {
                timeCompare(e.getClaims().getExpiration());
            }
        }
        return null;
    }

    private void timeCompare (Date tokenDate) {
        Date newDate = new Date();

        long dayms = 1000 * 24 * 60 * 60; // 天毫秒数
        long hoursms = 1000 * 60 * 60; // 小时毫秒数
        long minutesms = 1000 * 60; // 分钟毫秒数

        long differenceValue = newDate.getTime() - tokenDate.getTime();

        long dayDifference = differenceValue / dayms; // 计算差多少分钟
        long hoursDifference = differenceValue % dayms / hoursms; // 计算差多少分钟
        long minutesDifference = differenceValue % dayms % hoursms / minutesms; // 计算差多少分钟

        log.info("时间差:{}天{}小时{}分钟", dayDifference, hoursDifference, minutesDifference);
        redisTemplate.opsForValue().set("" + minutesDifference, minutesDifference);
    }

}
