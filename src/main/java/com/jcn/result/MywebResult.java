package com.jcn.result;

import lombok.Getter;
import lombok.Setter;

/**
 * 对输出结果进行封装
 * @param <T>
 */

@Getter
@Setter
public class MywebResult<T> {

    private int code;
    private String msg;
    private T data;

    public MywebResult(T data){
        this.data = data;
    }

    public MywebResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public MywebResult(MywebCodeMsg mywebCodeMsg){

        //如果mywebCodeMsg不等于null，则对code、msg进行赋值
        if(mywebCodeMsg != null) {
            this.code = mywebCodeMsg.getCode();
            this.msg = mywebCodeMsg.getMsg();
        }
    }

    /**
     * 成功的时候调用,成功只需要提供数据即可
     */
    public static <T> MywebResult<T> success(T data){
        return new MywebResult<T>(data);
    }

    /**
     * 失败的时候调用
     */
    public static <T> MywebResult<T> error(MywebCodeMsg mywebCodeMsg){
        return new MywebResult<T>(mywebCodeMsg);
    }

}
