package com.harry.hello.common.utils;

import java.io.Serializable;

public class JsonResult implements Serializable{

    public static final Integer SUCCESS = 1;
    public static final Integer FAIL = 0;

    //表示请求处理结果，成功或失败
    private Integer status;
    //请求成功时返回的JSON数据
    private Object data;
    //请求失败时返回的错误信息
    private String msg;

    public JsonResult(){

    }

    public JsonResult(Object data){
        this.status = SUCCESS;
        this.data = data;
    }

    public JsonResult(String msg){
        this.status = FAIL;
        this.msg = msg;
    }

    public JsonResult(Integer status, String data){
        this.status = status;
        this.data = data;
    }

    public JsonResult(Integer status, Object data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
