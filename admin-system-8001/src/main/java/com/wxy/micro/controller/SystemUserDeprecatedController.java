package com.wxy.micro.controller;

import com.wxy.micro.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 使用RestTemplate获取9001服务端的数据
 */
@RestController
@Deprecated
public class SystemUserDeprecatedController {
    private static final String REST_URL_PREFIX = "http://localhost:9001";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/save/user")
    int saveSystemUser(SystemUser systemUser){
        return  restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", systemUser, Integer.class);
    }
    @PostMapping(value = "/get/user")
    SystemUser selectSystemUserByInfo(SystemUser systemUser){
        return restTemplate.postForObject(REST_URL_PREFIX + "/get/user", systemUser, SystemUser.class);
    }
    @GetMapping(value = "/get/user/{id}")
    SystemUser getUserById(@PathVariable("id") String id){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/get/user/"+id,SystemUser.class);
    }
}
