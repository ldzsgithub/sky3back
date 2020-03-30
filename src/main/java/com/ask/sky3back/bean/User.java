package com.ask.sky3back.bean;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    String id;
    String username;
    String password;

    String phoneNumber;

    //1,2,3 部门id
    String authority;

    //0超级管理员 1管理员 2普通用户
    int loginflag;
    //0启用 1未启用
    int status;

    String[] auth;

    Set<Department> depts;
}
