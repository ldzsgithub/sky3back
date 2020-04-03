package com.ask.sky3back.controller;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.anno.auth.AuthPermission;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.common.util.auth.Auth;
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

    @AuthPermission
    @RequestMapping("/get")
    public JsonResult selectOrg() {
        User user = orgService.selectOrg(Auth.get(), Auth.getUsername());
        return new JsonResult(user);
    }

    @RequestMapping("/selectDepartment")
    public JsonResult selectDepartment() {

        return new JsonResult();
    }

}
