package com.ask.sky3back.common.base;

import java.io.Serializable;

public enum ResultStatus {
    SUCCESS(0, "成功"),
    ERROR(1, "异常"),

    NOT_FOUND_TOKEN(2, "参数[token]缺失!"),

    ERROR_USERNAME_EMPTY(2,"用户名不能为空"),
    ERROR_PASSWORD_EMPTY(2,"密码不能为空"),
    ERROR_PHONENUMBER_EMPTY(2,"手机号码不能为空"),
    ERROR_PHONENUMBER_FORMAT(2,"手机号码格式不正确"),
    ERROR_USER_EXIST(2,"用户名已经存在"),
    ERROR_USER_NOEXIST(2,"用户不存在"),
    ERROR_PASSWORD_WRONG(2,"密码错误"),


    ERROR_SYSTEM(3, "系统异常"),
    NOT_FOUND_USER(4, "没有用户"),
    PARAME_ERROR_PWD(5, "密码错误"),
    ERROR_PWD_OLD(6, "原始密码不正确"),
    ERROR_USER_EXISTS(7, "用户已存在,不能注册"),
    ERROR_CANNOT_BE_DELETED(8, "请先删除全部检测点，再删除主机"),
    ERROR_CAN_NOT_LOGIN(9, "用户带审核状态,不能登录"),
    ERROR_BASE_HAVE_USERS(10, "当前用户组存在用户,不能删除"),
    ERROR_BASE_EXISTS(11, "当前用户组已存在,不能创建"),
    ERROR_HOST_ADDRESS_EXISTS(12, "当前主机地址已存在,不能创建"),
    ERROR_HOST_COM_NOT_MISMATCH(13, "主机地址与com口数据不匹配");


    private int code;
    private String msg;

    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
