package com.jcn.redis.key.abstractkey;

import com.jcn.redis.key.interfacekey.KeyPrefix;
import lombok.AllArgsConstructor;

//通用缓存key封装：
//接口<-抽象类<-实现类
@AllArgsConstructor//通过构造函数，对变量进行赋值
public abstract class BasePrefix implements KeyPrefix {

    //抽象类，定义成员变量
    private int expireSeconds;
    private String prefix;

    //用户就没法new了
    public BasePrefix(String prefix) {//0代表永不过期
        this(0, prefix);
    }

    //默认0代表永不过期
    public int expireSeconds(){
        return expireSeconds;
    }

    public String getPrefix() {
        String className = getClass().getSimpleName();
        //类名拼上prefix
        return className+":" + prefix;
    }
}
