package com.jcn.utils;

import org.apache.commons.codec.digest.DigestUtils;

//MD5(MD5(pass明文+固定salt)+salt)
public class MD5Util {

    //MD5
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    //固定salt，写死客户端，如果是随机的话，服务器端不知道salt是什么东西
    private static final String salt = "a9s9j9c9t";

    //将明文密码加密一次
    public static String inputPassToFormPass(String inputPass) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //将加密好的密码再加密一次
    public static String formPassToDBPass(String formPass, String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }


    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        //form:ed21993c8c0bbd917545e6dc17327b5d
        String fs = inputPassToFormPass("123");
        String s = inputPassToDbPass("123","woshijianzhu");
        System.out.println(s);
    }

}
