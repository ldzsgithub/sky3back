package com.ask.sky3back.common.util.validate;

public class ValidateException extends Exception{

    private String msg;

    public ValidateException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
