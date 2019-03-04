package com.wxy.micro.service;

import com.wxy.micro.model.SystemUser;

import java.util.List;

public interface SystemUserService {
    int saveSystemUser(SystemUser systemUser);
    List<SystemUser> selectSystemUserListByInfo(SystemUser systemUser);
    SystemUser getUserById(String id);
    SystemUser getUserByUsernameAndPassword(String username,String password);

}
