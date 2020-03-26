package com.ask.sky3back.controller;

import com.ask.sky3back.common.base.JsonResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
@CrossOrigin
public class OrganizationController {

    @RequestMapping("/")
    public JsonResult updateUser() {

        return new JsonResult();
    }

    @RequestMapping("/selectDepartment")
    public JsonResult selectDepartment() {

        return new JsonResult();
    }

}
