package com.ask.sky3back.common.util.validate;

public class ValidateException extends Exception{

    private String msg;
    private int code;

    public ValidateException(String msg, int code){
        this.msg = msg;
        this.code = code;
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
