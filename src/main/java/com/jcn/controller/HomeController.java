package com.jcn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcn.entity.MyPic;
import com.jcn.service.impl.PicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PicServiceImpl picService;

    @RequestMapping("/home")
    public String home(Model model
            ,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        //model.addAttribute("picList",picList);

        PageHelper.startPage(pageNum,14);

        List<MyPic> pageList = picService.MyPicList();

        PageInfo<MyPic> pageInfo = new PageInfo<>(pageList);

        pageInfo.getList();

        model.addAttribute("pageInfo",pageInfo);

        return "home";
    }

}
