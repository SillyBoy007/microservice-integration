package com.wxy.micro.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "MICRO-SERVICE")
public interface SystemUserService {
    @PostMapping(value = "/save/user")
    int saveSystemUser(SystemUser systemUser);
    @PostMapping(value = "/get/users")
    List<SystemUser> selectSystemUserListByInfo(SystemUser systemUser);
    @GetMapping(value = "/get/user/{id}")
    SystemUser getUserById(@PathVariable("id")String id);
    @PostMapping("/login.do")
    SystemUser getUserByUsernameAndPassword(@RequestParam("username")String username, @RequestParam("password")String password);
}
