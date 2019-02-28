package com.ly.SpringBoot.CommonUtils;


/**
 * 自定义异常处理类
 */
public class CustomException extends RuntimeException{

    private Integer code;

    public CustomException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code=exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
