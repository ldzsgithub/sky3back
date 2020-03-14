package com.ask.sky3back.mapper;

import com.ask.sky3back.bean.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {

    void insertUser(User user);

    void deleteUserById(String id);

    void updateUser(User user);

    User selectUserById(String id);

    User selectUserByUsername(String username);

    User selectUserByUsernameAll(String userName);
}
