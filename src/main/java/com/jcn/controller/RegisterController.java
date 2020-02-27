package com.jcn.controller;

import com.jcn.service.impl.RegisterServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/do_register")
    public String do_register(@Param("acct") String acct,
                              @Param("password") String password,
                              @Param("username") String username,
                              @Param("email") String email,
                              HttpServletRequest request){

        registerService.insertMyAdmin(acct,password,username,email);

        request.setAttribute("success","注册成功，正在为您跳转到登陆页面");

        return "redirect:/index";
    }
}
