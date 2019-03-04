package com.wxy.micro.service.impl;

import com.wxy.micro.mapper.SystemUserMapper;
import com.wxy.micro.model.SystemUser;
import com.wxy.micro.model.SystemUserExample;
import com.wxy.micro.service.SystemUserService;
import com.wxy.micro.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    SystemUserMapper systemUserMapper;
    @Override
    public int saveSystemUser(SystemUser systemUser) {
        return systemUserMapper.insert(systemUser);
    }

    @Override
    public List<SystemUser> selectSystemUserListByInfo(SystemUser systemUser) {
        SystemUserExample systemUserExample = new SystemUserExample();
        SystemUserExample.Criteria criteria = systemUserExample.createCriteria();
        criteria.andUsernameEqualTo(systemUser.getUsername());
        criteria.andPasswordEqualTo(systemUser.getPassword());
        List<SystemUser> sysuser = systemUserMapper.selectByExample(systemUserExample);
        return sysuser;
    }

    @Override
    public SystemUser getUserById(String id) {
        return systemUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean loginCheck(String username, String password) {
        SystemUserExample systemUserExample = new SystemUserExample();
        SystemUserExample.Criteria criteria = systemUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<SystemUser> sysuser = systemUserMapper.selectByExample(systemUserExample);
        if (StringUtils.isEmpty(sysuser)){
            return false;
        }
        if (sysuser.size()>0){
            return true;
        }
        return false;
    }


}
