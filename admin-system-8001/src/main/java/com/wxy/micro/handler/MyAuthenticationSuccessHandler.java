package com.wxy.micro.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxy.micro.LoginType;
import com.wxy.micro.config.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登陆
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties myProperties;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {


        // Authentication  封装认证信息
        // 登录方式不同，Authentication不同

            logger.info("MyAuthenticationSuccessHandler login success!");
            if (LoginType.JSON.equals(myProperties.getLoginType())) {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                // 把authentication对象转成 json 格式 字符串 通过 response 以application/json;charset=UTF-8 格式写到响应里面去
                httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
            } else {
                // 父类的方法 就是 跳转
                super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
            }
    }
}
