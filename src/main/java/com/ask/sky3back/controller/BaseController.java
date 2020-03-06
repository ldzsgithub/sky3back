package com.ask.sky3back.controller;

import com.ask.sky3back.common.base.JsonResult;
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
    public JsonResult selectUserById(String id, @NotEmpty(msg = "自定义的错误信息") String phoneNumber) {
        return new JsonResult(baseService.selectUserById(id));
    }

}
