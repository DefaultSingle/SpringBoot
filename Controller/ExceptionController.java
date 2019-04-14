package com.ly.SpringBoot.Controller;

import com.ly.SpringBoot.Exception.EnumExption;
import com.ly.SpringBoot.Exception.JException;
import com.ly.SpringBoot.Exception.Result;
import com.ly.SpringBoot.Service.ExceptionServece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @Autowired
    private ExceptionServece exceptionServece;

    @GetMapping("/textExcetion")
    public Result textException(){
       Result result = new Result();
       if(true){
           throw new JException(EnumExption.ERROR_EXCEPTION);
       }
       return  result;
    }

    @GetMapping("/textExcetionTwo")
    public Result textExcetionTwo(){
        Result result = new Result();
        exceptionServece.textException();
        return  result;
    }

}
