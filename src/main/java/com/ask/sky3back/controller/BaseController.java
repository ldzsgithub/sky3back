package com.ask.sky3back.controller;

import com.ask.sky3back.common.anno.auth.AuthPermission;
import com.ask.sky3back.common.anno.auth.AuthRole;
import com.ask.sky3back.common.anno.validate.RE;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.common.anno.validate.NotEmpty;
import com.ask.sky3back.service.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RestController
@RequestMapping("/")
public class BaseController {

    @Autowired
    private BaseServiceImpl baseService;

    @RequestMapping("/selectUserById")
    public JsonResult selectUserById(String id, @NotEmpty(msg = "自定义的错误信息") String phoneNumber) {
        return new JsonResult(baseService.selectUserById(id));
    }

    @AuthPermission
    @RequestMapping("/a")
    public JsonResult s(HttpServletResponse a,HttpServletRequest b) {
        String ip = b.getHeader("x-forwarded-for")==null?b.getRemoteAddr():null;
        return new JsonResult("访问成功"+ip);
    }

    @RequestMapping("/b")
    public JsonResult b() {
        return new JsonResult("访问成功role");
    }

    @RequestMapping("/login")
    public JsonResult login() {
        return new JsonResult("访问成功login");
    }

}
