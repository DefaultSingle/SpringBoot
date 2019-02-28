package com.ly.SpringBoot.CommonUtils;

import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * redis工具类
 */
@Component
public class RedisUtil {
   @Autowired
    private RedisTemplate<String,String> redisTemplate;

   @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //---------------------------common--------------------//

    /**
     * 指定缓存的失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time){
        try {
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取指定key缓存的失效时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断是否包含某个键
     * @param key
     * @return true存在 false不存在
     */
    public boolean hasKey(String key){
        try {
            redisTemplate.hasKey(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存 可以是一个也可以是多个
     * @param key
     */
    public void delete(String ...key){
       if(key!=null&&key.length==1){
           redisTemplate.delete(key[0]);
       }else{
           redisTemplate.delete(CollectionUtils.arrayToList(key));
       }
    }
    //------------------------------String-----------------------//
    /**
     * 读出操作
     */
    public String get(final String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }
    /**
     * 写入缓存
     */
    public boolean set(final String key,String value){
        boolean flag = false;
        try {
            redisTemplate.opsForValue().set(key,value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 写入缓存并设置过期时间
     * @param key
     * @param value
     * @param time  过期时间 time要大于0，如果小于0将设置无限期
     * @return  true 成功 false失败
     */
    public boolean set(String key,String value,long time){

        try {
            if(time>0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                redisTemplate.opsForValue().set(key,value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key
     * @param l
     * @return
     */
    public long increment(String key,long l){
         if(l<0){
             throw new RuntimeException("递增因子必须大于0");
         }
         return redisTemplate.opsForValue().increment(key,l);
    }
    /**
     * 递减
     * @param key
     * @param l
     * @return
     */
    public long decrement(String key,long l){
        if(l<0){
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,-l);
    }
    /**
     * 修改操作
     */
    public boolean getAndSet(final String key,String value){
        boolean flag = false;
        try {
            redisTemplate.opsForValue().getAndSet(key,value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return flag;
    }
    /**
     * 删除操作
     */
    public boolean delete(final String key){
        boolean flag = false;
        try {
            redisTemplate.delete(key);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    //-------------------------Map-------------------------------//

    /**
     * 向缓存中写入map
     * @param key
     * @param map
     * @return
     */
    public boolean putAll(String key,HashMap<String,Object> map){

        try {
            redisTemplate.opsForHash().putAll(key,map);
//            redisTemplate.boundHashOps(key).putAll(map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向缓存中写入数据并设置过期时间
     * @param key
     * @param map
     * @param time
     * @return
     */
    public boolean putAll(String key,HashMap<String,Object> map,long time){

        try {
            redisTemplate.opsForHash().putAll(key,map);
            if(time>0){
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
