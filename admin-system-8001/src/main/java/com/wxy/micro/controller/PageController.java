package com.wxy.micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  PageController {
    private final String PREFIX = "views/";
    /**
     * 欢迎页
     * @return
     */
    @GetMapping(value = {"/","/index","welcome"})
    public String indexPage() {
        return "welcome";
    }
    /**
     * 登陆页面
     * @return
     */
    @GetMapping(value = {"/user/login","/login"})
    public String loginPage() {
        return PREFIX+"login";
    }

}
