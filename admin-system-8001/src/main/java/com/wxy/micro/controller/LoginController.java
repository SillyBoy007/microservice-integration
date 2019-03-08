package com.wxy.micro.controller;


import com.wxy.micro.entity.RetObject;
import com.wxy.micro.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class LoginController {
    @Autowired
    SystemUserService systemUserService;
    @PostMapping("/login.do")
    public RetObject doLogin(SystemUser systemUser){
        SystemUser user = systemUserService.getUserByUsernameAndPassword(systemUser.getUsername(), systemUser.getPassword());
        if (user == null) return RetObject.failRet("登录失败",1002);
        if (user.getId() == null){
            return RetObject.failRet("登录失败",1002);
        }else {
            return RetObject.successRet("登录成功",null);

        }
    }
}
