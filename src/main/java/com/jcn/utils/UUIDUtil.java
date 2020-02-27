package com.jcn.utils;

import java.util.UUID;

//帮助类
public class UUIDUtil {
    public static String uuid() {
        //返回定义的uuid                               去掉-
        return UUID.randomUUID().toString().replace("-", "");
    }
}
