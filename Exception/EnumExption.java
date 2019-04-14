package com.ly.SpringBoot.Exception;

/**
 * 自定义异常枚举对象
 */
public enum EnumExption {

    ERROR_EXCEPTION(1001,"长得不够帅"),

    ERROR_EXCEPTON_HEIGHT(1002,"个子不够高");

    private Integer code;

    private String message;

    EnumExption(Integer code,String message){
        this.code = code;
        this.message = message;
    }

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
}
