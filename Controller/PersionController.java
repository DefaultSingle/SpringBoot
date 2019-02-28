package com.ly.SpringBoot.Controller;

import com.ly.SpringBoot.CommonUtils.CustomException;
import com.ly.SpringBoot.CommonUtils.ExceptionEnum;
import com.ly.SpringBoot.CommonUtils.RestFul;
import com.ly.SpringBoot.CommonUtils.RestFulUtils;
import com.ly.SpringBoot.Entity.Persion;
import com.ly.SpringBoot.Entity.Women;
import com.ly.SpringBoot.Service.PersionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PersionController {
    @Autowired
    private PersionInterface persionInterface;
    @RequestMapping("/textJpa")
    public void getPersionInfo(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        persionInterface.save(new Persion("8", "aa@127.com", "a1", "169@qq.com","k",formattedDate));
        List<Persion> list=persionInterface.findAll();
    }
    @RequestMapping(value = "/index")
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "thymeleaf/hello";
    }
    @RequestMapping("/textAjax")
    @ResponseBody
    public boolean textAjax(@RequestParam("name") String name){
        System.out.println("get请求过来的参数"+name);
        return true;
    }
    @RequestMapping(value = "/textUrl/{key}",method= RequestMethod.GET)
    @ResponseBody
    public boolean textUrl(@PathVariable("key") String key){
        System.out.println("get过来的请求参数"+key);
        return true;
    }
    @RequestMapping("/textForm")
    @ResponseBody
    public boolean textForm(@RequestParam("name") String name,
                               @RequestParam("pass") String pass){
        System.out.println("测试form表单提交"+name+pass);
        return true;
    }
    @RequestMapping("/textJson")
    @ResponseBody
    public RestFul textJson (@RequestBody Women women){
        System.out.println("测试form表单提交"+women.getName()+women.getPass());
        if(women.getName() == "a") {
            throw new CustomException(ExceptionEnum.ERRO_MESSAGE);

        }else{
            return RestFulUtils.restFul(1,"错误",women);
        }
    }
}
