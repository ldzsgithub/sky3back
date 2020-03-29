package com.ask.sky3back.controller;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.anno.validate.NotNull;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.service.OrgService;
import com.ask.sky3back.service.serviceImpl.OrgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
@CrossOrigin
public class OrganizationController {
    @Autowired
    private OrgServiceImpl orgService;
    @RequestMapping("/")
    public JsonResult updateUser(@NotNull String userId) {
        User user = orgService.selectOrgByUserId(userId);
        return new JsonResult();
    }

    @RequestMapping("/selectDepartment")
    public JsonResult selectDepartment() {

        return new JsonResult();
    }

}
