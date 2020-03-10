package com.ask.sky3back.controller;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.anno.validate.NotEmpty;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.common.base.ResultStatus;
import com.ask.sky3back.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public JsonResult login(@NotEmpty(msg = "用户名不能为空") String username, @NotEmpty(msg = "密码不能为空")String password) {
        String jwt = userService.checkLogin(username, password);
        if(jwt == null) {
            return new JsonResult(ResultStatus.LOGIN_FAIL);
        }
        return new JsonResult(jwt);
    }

    @RequestMapping("/register")
    public JsonResult register(@NotEmpty(msg = "用户名不能为空") String username, @NotEmpty(msg = "密码不能为空")String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        userService.insertUser(user);
        return new JsonResult(ResultStatus.SUCCESS_REGISTER);
    }

}
