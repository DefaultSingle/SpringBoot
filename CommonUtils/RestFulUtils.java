package com.ly.SpringBoot.CommonUtils;


/**
 * 同一返回工具类
 */
public class RestFulUtils {

    public static RestFul restFul(Integer code,String message,Object object){
        RestFul restFul = new RestFul();
        restFul.setCode(code);
        restFul.setMessage(message);
        restFul.setObject(object);
        return  restFul;
    }
}
