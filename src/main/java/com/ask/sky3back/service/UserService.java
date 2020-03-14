package com.ask.sky3back.service;

import com.ask.sky3back.bean.User;

public interface UserService {

    boolean registerUser(User user);

    void deleteUserById(String id);

    void updateUser(User user);

    User selectUserById(String id);

    User selectUserByUsername(String username);

    String checkLogin(String username, String password);
}
