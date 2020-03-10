package com.ask.sky3back.bean;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    String id;
    String userName;
    String password;

    String authority;
    int role;

    int status;

    String[] auth;
}
