package com.wxy.micro.config;

import com.wxy.micro.LoginType;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityProperties {
    private LoginType loginType = LoginType.JSON;
    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

}
