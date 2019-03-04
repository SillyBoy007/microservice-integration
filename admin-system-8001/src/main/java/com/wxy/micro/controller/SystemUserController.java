package com.wxy.micro.controller;

import com.wxy.micro.model.SystemUser;
import com.wxy.micro.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SystemUserController {
    @Autowired
    private SystemUserService deptService;

    @PostMapping(value = "/save/user")
    int saveSystemUser(SystemUser systemUser){
        return deptService.saveSystemUser(systemUser);
    }
    @PostMapping(value = "/get/users")
    List<SystemUser> selectSystemUserListByInfo(SystemUser systemUser){
        return deptService.selectSystemUserListByInfo(systemUser);
    }
    @GetMapping(value = "/get/user/{id}")
    SystemUser getUserById(@PathVariable("id") String id){
        return  deptService.getUserById(id);
    }
}
