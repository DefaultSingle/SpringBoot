package com.ly.SpringBoot.JunitText;

import com.ly.SpringBoot.CommonUtils.JsonUtils;
import com.ly.SpringBoot.CommonUtils.RedisUtil;
import com.ly.SpringBoot.CommonUtils.SerializeUtil;
import com.ly.SpringBoot.Entity.JunitUser;
import com.ly.SpringBoot.Entity.Two;
import com.ly.SpringBoot.Service.ManService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 对redis缓存进行测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisUtilsText {
   @Autowired
   private RedisUtil redisUtil;

   @Autowired
   private SerializeUtil serializeUtil;
   @Resource
   private ManService manService;

   @Test
   public void set(){
        redisUtil.set("kkk","firstRedis");
   }
   @Test
   public void get(){
        String value = redisUtil.get("kkk");
       System.out.println(value);
   }
   @Test
   public void JunitUser(){
        JunitUser junitUser = new JunitUser();
        junitUser.setName("刘洋");
        junitUser.setAge(25);
        redisUtil.set("liuyag", JsonUtils.objToString(junitUser));
   }
   @Test
    public void addMan(){
       Two man = new Two();
       man.setAge(25);
       man.setName("刘洋");
       man.setDescrept("一个菜鸟");
       boolean flag= manService.addMan(man);
   }
   @Test
   public void select(){
        manService.selectMan(1L);
   }
   @Test
    public void delete(){
       manService.delete(3L);
   }

}
