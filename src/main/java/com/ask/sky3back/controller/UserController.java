package com.ask.sky3back.controller;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.anno.validate.NotEmpty;
import com.ask.sky3back.common.anno.validate.RE;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.common.base.ResultStatus;
import com.ask.sky3back.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public JsonResult login(@NotEmpty(msg = "请输入用户名") String username,
                            @NotEmpty(msg = "请输入密码")String password) {
        String jwt = userService.checkLogin(username, password);
        if(jwt == null) {
            return new JsonResult(ResultStatus.LOGIN_FAIL);
        }
        return new JsonResult(jwt);
    }

    @RequestMapping("/register")
    public JsonResult register(@NotEmpty(msg = "请输入用户名") String username,
                               @NotEmpty(msg = "请输入密码")String password,
                               @NotEmpty(msg = "请输入电话号码") @RE(re = RE.only_number, msg = "请输入正确的电话号码") String phoneNumber) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        if(userService.registerUser(user)) {
            return new JsonResult(ResultStatus.SUCCESS_REGISTER);
        }
        return new JsonResult(ResultStatus.REGISTER_FAIL_EXIST);
    }

    @RequestMapping()
    public JsonResult updateUser() {

        return new JsonResult();
    }

    @RequestMapping()
    public JsonResult selectUser() {

        return new JsonResult();
    }

    @RequestMapping()
    public JsonResult deleteUser() {

        return new JsonResult();
    }
}
