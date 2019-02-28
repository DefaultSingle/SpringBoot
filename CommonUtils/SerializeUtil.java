package com.ly.SpringBoot.CommonUtils;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化对象工具
 * 在缓存对象时进行使用 因为redis没有提供对Object缓存的支持
 */
@Component
public class SerializeUtil {
    /**
     * 将对象序列化为字节方便村粗
     * @param object
     * @return
     */
    public byte[] serialize(Object object){
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] objByte = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return objByte;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 反序列
     * @param byt
     * @return
     */
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
