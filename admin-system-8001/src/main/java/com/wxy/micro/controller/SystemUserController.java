package com.wxy.micro.controller;

import com.wxy.micro.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @PostMapping(value = "/save/user")
    int saveSystemUser(SystemUser systemUser){
        return systemUserService.saveSystemUser(systemUser);
    }
    @PostMapping(value = "/get/users")
    List<SystemUser> selectSystemUserListByInfo(SystemUser systemUser){
        return systemUserService.selectSystemUserListByInfo(systemUser);
    }
    @GetMapping(value = "/get/user/{id}")
    SystemUser getUserById(@PathVariable("id") String id){
        return  systemUserService.getUserById(id);
    }
}
