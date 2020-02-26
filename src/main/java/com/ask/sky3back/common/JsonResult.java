package com.ask.sky3back.common;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    public static final int SUCCESS=0;
    public static final int ERROR=1;
    public static final int OTHER=2;

    private int state;
    private String message = "";
    private T data;
    private String pass="";

    public JsonResult(){
        state = SUCCESS;
    }
    public JsonResult(int state, String message, T data) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
    }
    public JsonResult(int state,String error){
        this(state,error,null);
    }
    public JsonResult(int state,T data){
        this(state,"",data);
    }
    public JsonResult(String error){
        this(ERROR,error,null);
    }

    public JsonResult(T data){
        this(SUCCESS,"",data);
    }
    public JsonResult(int state){
        this(state,"",null);
    }
    public JsonResult(Throwable e){
        this(ERROR,e.getMessage(),null);
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public static int getSuccess() {
        return SUCCESS;
    }
    public static int getError() {
        return ERROR;
    }
    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", message=" + message + ", pass=" + pass + ", data=" + data + "]";
    }
}
