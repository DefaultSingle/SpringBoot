package com.ly.SpringBoot.Exception;

/**
 * 自定义异常
 * 需要继承runTimeException
 */
public class JException extends RuntimeException{

    private int code;

    private String message;

    public JException(EnumExption e){
        this.message = e.getMessage();
        this.code = e.getCode();
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
