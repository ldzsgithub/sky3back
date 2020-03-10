package com.ask.sky3back.common.base;

public class JsonResult<T> {

    private String msg;
    private int state;
    private T data;

    public JsonResult() {
        this(ResultStatus.SUCCESS);
    }

    public JsonResult(String msg, int state, T data) {
        this.msg = msg;
        this.state = state;
        this.data = data;
    }

    public JsonResult(ResultStatus resultStatus) {
        this.msg = resultStatus.getMsg();
        this.state = resultStatus.getCode();
        this.data = null;
    }

    public JsonResult(ResultStatus resultStatus, T obj) {
        this.msg = resultStatus.getMsg();
        this.state = resultStatus.getCode();
        this.data = obj;
    }

    public JsonResult(T obj) {
        this.msg = ResultStatus.SUCCESS.getMsg();
        this.state = ResultStatus.SUCCESS.getCode();
        this.data = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T date) {
        this.data = date;
    }

    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", msg=" + msg  + ", data=" + data + "]";
    }

}
