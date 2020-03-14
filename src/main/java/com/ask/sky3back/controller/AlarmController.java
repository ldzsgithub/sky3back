package com.ask.sky3back.controller;

import com.ask.sky3back.common.anno.validate.NotEmpty;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.common.base.ResultStatus;
import com.ask.sky3back.service.serviceImpl.AlarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alarm")
public class AlarmController {
    @Autowired
    private AlarmServiceImpl alarmService;

    @RequestMapping("/select")
    public JsonResult login1212() {
        return new JsonResult();
    }
}
