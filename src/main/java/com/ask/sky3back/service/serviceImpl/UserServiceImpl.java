package com.ask.sky3back.service.serviceImpl;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.base.Constant;
import com.ask.sky3back.common.util.MD5;
import com.ask.sky3back.common.util.UUID;
import com.ask.sky3back.mapper.UserMapper;
import com.ask.sky3back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean registerUser(User user) {
        if(userMapper.selectUserByUsernameAll(user.getUsername()) != null) {
            return false;
        };
        user.setId(UUID.getUUID());
        user.setLoginflag(Constant.DEFAULT_USER_ROLE);
        user.setAuthority(Constant.DEFAULT_USER_PERMISSION);
        user.setStatus(Constant.DEFAULT_USER_STATE);
        userMapper.insertUser(user);
        return true;
    }

    @Override
    public void deleteUserById(String id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public String checkLogin(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if(user == null) return null;
        if(user.getPassword() != null && user.getPassword().equals(password)) {
            return MD5.getmd5(MD5.charToUnicode(username));
        }
        return null;
    }
}
