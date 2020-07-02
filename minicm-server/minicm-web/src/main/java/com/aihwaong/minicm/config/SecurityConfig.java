package com.aihwaong.minicm.config;

import com.aihwaong.minicm.model.Personnel;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.PersonnelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.config
 * +-------------------------------------------------------
 * | @Title:         Security配置类
 * +-------------------------------------------------------
 * | @ProjectName:   cm
 * +-------------------------------------------------------
 * | @Description:   响应规则，认证成功、失败回调
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/15 23:17
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private PerssonelDecisionManager perssonelDecisionManager;

    @Autowired
    private PerssonelSecurityFilter perssonelSecurityFilter;

    /**
     * 加密方式
     * SHA-256 + 随机盐 + 密钥进行加密
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personnelService);
    }

    /**
     * 响应规则
     *
     * @param http HttpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(perssonelDecisionManager);
                        object.setSecurityMetadataSource(perssonelSecurityFilter);
                        return object;
                    }
                })
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
                "/swagger-resources", "/swagger-resources/configuration/security",
                "/swagger-ui.html", "/webjars/**")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("account")
                .passwordParameter("password")
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    // 验证成功
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter printWriter = response.getWriter();
                        Personnel personnel = (Personnel) authentication.getPrincipal();
                        personnel.setPassword(null);  // 需要返回前端，去掉密码
                        String objectMapper = new ObjectMapper().writeValueAsString(ResponseBean.buildResponseBean().success("登录成功", personnel));
                        printWriter.write(objectMapper);
                        printWriter.close();
                    }
                }).failureHandler(new AuthenticationFailureHandler() {
            // 验证失败
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                ResponseBean responseBean = ResponseBean.buildResponseBean();
                responseBean.fail("登录失败");

                if (exception instanceof BadCredentialsException) {
                    // 用户名或密码错误
                    responseBean.setMessage("用户名或密码错误,请重新输入");
                }

                PrintWriter printWriter = response.getWriter();
                String writeValueAsString = new ObjectMapper().writeValueAsString(responseBean);
                printWriter.write(writeValueAsString);
                printWriter.close();
            }
        })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    // 注销登录
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter printWriter = response.getWriter();
                        String valueAsString = new ObjectMapper().writeValueAsString(ResponseBean.buildResponseBean().success("Logout successful"));
                        printWriter.write(valueAsString);
                        printWriter.close();
                    }
                })
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                //没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint((req, resp, authException) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            resp.setStatus(401);
                            PrintWriter out = resp.getWriter();
                            ResponseBean responseBean = ResponseBean.buildResponseBean().fail("访问失败!");
                            if (authException instanceof InsufficientAuthenticationException) {
                                responseBean.setMessage("请求失败!");
                            }
                            out.write(new ObjectMapper().writeValueAsString(responseBean));
                            out.flush();
                            out.close();
                        }
                );
    }
}
