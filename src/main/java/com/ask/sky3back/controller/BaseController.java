package com.ask.sky3back.controller;

import com.ask.sky3back.common.JsonResult;
import com.ask.sky3back.common.anno.validate.NotEmpty;
import com.ask.sky3back.service.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/")
public class BaseController {

    @Autowired
    private BaseServiceImpl baseService;

    @RequestMapping("/selectUserById")
    public JsonResult selectUserById(String id, @NotEmpty(msg = "asdww11") String phoneNumber) {
        System.out.println("我是controller");
        System.out.println("我是controller"+phoneNumber);
        return new JsonResult(baseService.selectUserById(id));
    }

    public JsonResult sss(String msg) {
        return new JsonResult(msg);
    }
}
