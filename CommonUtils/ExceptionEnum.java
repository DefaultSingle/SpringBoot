package com.ly.SpringBoot.CommonUtils;


/**
 * 枚举类
 */
public enum ExceptionEnum {
    ERRO_MESSAGE(500,"错误信息")
    ;
    private Integer code;

    private String Message;

     ExceptionEnum(Integer code, String message) {
        this.code = code;
        Message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
