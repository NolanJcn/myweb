package com.jcn.result;

import lombok.*;

/**
 * key,value数据类
 * 对接口输出结果进行封装
 */
@Getter
//为了更好的封装，如果不希望用户修改数据，可以去掉set方法
//有些接口是不需要暴露给客户端的
//@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MywebCodeMsg {

    private int code;
    private String msg;

    //通用的错误码 10x
    public static MywebCodeMsg SUCCESS = new MywebCodeMsg(0,"success");
    public static MywebCodeMsg SERVER_ERROR = new MywebCodeMsg(100, "服务端异常");
    public static MywebCodeMsg BIND_ERROR = new MywebCodeMsg(101, "参数校验异常：%s");
    public static MywebCodeMsg REQUEST_ILLEGAL = new MywebCodeMsg(102, "请求非法");
    public static MywebCodeMsg ACCESS_LIMIT_REACHED= new MywebCodeMsg(103, "访问太频繁！");
    //登录模块 20x
    public static MywebCodeMsg SESSION_ERROR = new MywebCodeMsg(201, "Session不存在或者已经失效");
    public static MywebCodeMsg PASSWORD_EMPTY = new MywebCodeMsg(202, "登录密码不能为空");
    public static MywebCodeMsg ACCT_EMPTY = new MywebCodeMsg(203, "账号不能为空");
    public static MywebCodeMsg ACCT_ERROR = new MywebCodeMsg(204, "输入格式错误");
    public static MywebCodeMsg ACCT_NOT_EXIST = new MywebCodeMsg(205, "账号不存在");
    public static MywebCodeMsg PASSWORD_ERROR = new MywebCodeMsg(206, "密码错误");
    public static MywebCodeMsg REGISTER_ACCT_ERROR = new MywebCodeMsg(207, "该账号已经存在，请重新输入");
    //图片上传模块30X
    public static MywebCodeMsg PIC_NULL_ERROR = new MywebCodeMsg(301, "请选择图片后进行操作");
    public static MywebCodeMsg PIC_FORMAT_ERROR = new MywebCodeMsg(302, "请选择正确图片格式的文件");
    public static MywebCodeMsg PIC_TYPE_NULL_ERROR = new MywebCodeMsg(303, "请选择图片的类别后进行操作");
    public static MywebCodeMsg PIC_NAME_NULL_ERROR = new MywebCodeMsg(304, "请为图片设置一个名称后进行操作");
    public static MywebCodeMsg PIC_ERROR = new MywebCodeMsg(305, "图片上传失败，请重新选择进行上传");

    //参数异常。变参
    public MywebCodeMsg fillArgs(Object... args){

        //code还是原始的code
        int code = this.code;

        //只需要生成新的message即可，拼接成新的message
        String message = String.format(this.msg,args);

        return new MywebCodeMsg(code,message);
    }

}
