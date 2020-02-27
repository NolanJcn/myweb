package com.jcn.redis.key;

import com.jcn.redis.key.abstractkey.BasePrefix;

public class MyAdminKey extends BasePrefix {

    //TOKEN有效期
    public static final int TOKEN_EXPIRE = 3600*24 * 2;

    public MyAdminKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MyAdminKey token = new MyAdminKey(TOKEN_EXPIRE,"tk");

    //对象缓存希望是永久有效的，所以不设置有效期
    public static MyAdminKey getByAcct = new MyAdminKey(0,"id");

}
