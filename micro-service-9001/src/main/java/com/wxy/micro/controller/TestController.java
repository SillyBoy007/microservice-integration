package com.wxy.micro.controller;

import com.wxy.micro.mapper.SystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    SystemUserMapper systemUserMapper;
    @RequestMapping("/test")
    @ResponseBody()
    public void fun(){

    }
}
