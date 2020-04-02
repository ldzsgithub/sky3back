package com.ask.sky3back.service.serviceImpl;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.mapper.UserMapper;
import com.ask.sky3back.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orgService")
public class OrgServiceImpl implements OrgService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOrg(String[] auth, String username) {
        return userMapper.selectOrg(auth, username);
    }
}
