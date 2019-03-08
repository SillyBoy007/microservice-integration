package com.wxy.micro.controller;


import com.wxy.micro.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private SystemUserService systemUserService;
    @PostMapping("/login.do")
    public SystemUser doLogin(SystemUser systemUser){
        SystemUser user = systemUserService.getUserByUsernameAndPassword(systemUser.getUsername(), systemUser.getPassword());
       return user;
    }
}
