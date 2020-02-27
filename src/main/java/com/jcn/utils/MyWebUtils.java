package com.jcn.utils;

import com.alibaba.fastjson.JSON;

/***
 * 公共工具类
 */
public class MyWebUtils {

    //判断字符串是否有效
    public static boolean strIfEffective(String str){
        //是空字符串
        if ((str == null) || (str.length() <= 0)){
            return false;
        }
        //是非法字符串
        if(! str.matches("[a-zA-Z0-9_\u4e00-\u9fa5]*")){
            return false;
        }
        //字符串有效
        return true;
    }

    //压制警告
    @SuppressWarnings("unchecked")
    //把字符串转化为bean对象
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if(!strIfEffective(str) || clazz == null) {
            return null;
        }
        //clazz如果是整型的话，就直接进行类型转化即可
        if(ClazzFor.clazzForInt(clazz)) {
            return (T)Integer.valueOf(str);
        }else if(ClazzFor.clazzForStr(clazz)) {
            return (T)str;
        }else if(ClazzFor.clazzForLong(clazz)) {
            return  (T)Long.valueOf(str);
        }else {
            //parseObject：将json字符串转换为bean对象
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    //将任意类型转化为字符串
    public static <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        //如果是int，long型，则直接写入，否则进行转型
        if(ClazzFor.clazzForInt(clazz)) {
            return ""+value;
        }else if(ClazzFor.clazzForStr(clazz)) {
            return (String)value;
        }else if(ClazzFor.clazzForLong(clazz)) {
            return ""+value;
        }else {
            //将bean对象转换为json字符串
            return JSON.toJSONString(value);
        }
    }


}
