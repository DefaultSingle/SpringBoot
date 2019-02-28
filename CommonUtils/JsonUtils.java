package com.ly.SpringBoot.CommonUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * 对象的来回转换
 */
@Component
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成字符串
     * @param object
     * @return
     */
    public static String objToString(Object object){

        try {
            String string = MAPPER.writeValueAsString(object);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串转化为对象
     * @param objData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T stringToObj(String objData,Class<T> beanType){
        try {
            T t = MAPPER.readValue(objData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
