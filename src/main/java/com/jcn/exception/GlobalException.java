package com.jcn.exception;

import com.jcn.result.MywebCodeMsg;
import lombok.Getter;

//全局业务异常
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    //获取参数
    @Getter
    private MywebCodeMsg codeMsg;

    public GlobalException(MywebCodeMsg codeMsg){
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

}
