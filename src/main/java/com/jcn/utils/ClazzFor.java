package com.jcn.utils;

public class ClazzFor {

    public static boolean clazzForInt(Class<?> clazz){
        Boolean bool = (clazz == long.class || clazz == Long.class);
        return bool;
    }

    public static boolean clazzForLong(Class<?> clazz){
        Boolean bool = (clazz == long.class || clazz == Long.class);
        return bool;
    }

    public static boolean clazzForStr(Class<?> clazz){
        Boolean bool = (clazz == String.class);
        return bool;
    }

}
