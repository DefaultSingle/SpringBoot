package com.ly.SpringBoot.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exception(JException j){
      Result result = new Result();
      result.setCode(j.getCode());
      result.setMessage(j.getMessage());
      return  result;
    }
}
