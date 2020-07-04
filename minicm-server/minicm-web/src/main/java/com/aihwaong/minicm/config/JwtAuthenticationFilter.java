package com.aihwaong.minicm.config;

import com.aihwaong.minicm.model.Personnel;
import com.aihwaong.minicm.model.ResponseBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * | @date:          2020/7/4 16:10
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken uToken = new UsernamePasswordAuthenticationToken(account, password);
        return this.authenticationManager.authenticate(uToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Personnel personnel = (Personnel) authResult.getPrincipal();
        List<String> roles = personnel.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        SecretKey secretKey = Keys.hmacShaKeyFor(JwtConfigInfo.TOKEN_KEY.getBytes());
        String token = Jwts.builder()
                .setHeaderParam("TYP", JwtConfigInfo.TOKEN_TYPE)
                .setSubject("" + personnel.getId())
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 120 * 1000)) // 过期时间
                .setIssuer(JwtConfigInfo.TOKEN_ISS)
                .claim("roles", roles)
                .signWith(secretKey)
                .compact();

        responseData(response, token, personnel);
    }

    private void responseData(HttpServletResponse response, String token, Personnel personnel) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader(JwtConfigInfo.TOKEN_HEADER, JwtConfigInfo.TOKEN_PREFIX + token);

        personnel.setPassword(null);  // 需要返回前端，去掉密码
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("data", personnel);
        stringObjectMap.put("token", "Bearer " + token);
        String objectMapper = new ObjectMapper().writeValueAsString(ResponseBean.buildResponseBean().success("登录成功", stringObjectMap));

        PrintWriter printWriter = response.getWriter();
        printWriter.write(objectMapper);
        printWriter.close();
    }

}
