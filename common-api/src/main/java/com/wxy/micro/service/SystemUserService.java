package com.wxy.micro.service;

import com.wxy.micro.model.SystemUser;
import com.wxy.micro.model.SystemUserExample;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICRO-SERVICE")
public interface SystemUserService {
    @PostMapping(value = "/save/user")
    int saveSystemUser(SystemUser systemUser);
    @PostMapping(value = "/get/users")
    List<SystemUser> selectSystemUserListByInfo(SystemUser systemUser);
    @GetMapping(value = "/get/user/{id}")
    SystemUser getUserById(@PathVariable("id")String id);

}
