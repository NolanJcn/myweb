package com.jcn.controller;

import com.jcn.result.MywebResult;
import com.jcn.service.impl.LoginServiceImpl;
import com.jcn.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginServiceImpl loginService;

    //跳转登陆页面
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

    //登陆操作
    @ResponseBody
    @RequestMapping("/do_login")
    public MywebResult<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){

        log.info(loginVo.toString());

        String result = loginService.login(response,loginVo);

        return MywebResult.success(result);
    }
}
