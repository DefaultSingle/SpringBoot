package com.ly.SpringBoot.ServiceImpl;

import com.ly.SpringBoot.Exception.EnumExption;
import com.ly.SpringBoot.Exception.JException;
import com.ly.SpringBoot.Service.ExceptionServece;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionServece{
    @Override
    public void textException() {
        if(true){
            throw new JException(EnumExption.ERROR_EXCEPTON_HEIGHT);
        }
    }
}
