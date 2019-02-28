package com.ly.SpringBoot.CommonUtils;


/**
 * 统一的返回对象
 */
public class RestFul {

    //状态码
    private Integer code;
    //异常信息
    private String message;
    //异常时返回对象
    private Object object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
