package com.jcn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcn.entity.MyPic;
import com.jcn.service.impl.PicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PicSelectController {

    @Autowired
    private PicServiceImpl picService;

    @RequestMapping("/picwall")
    public String picWall(Model model,
                          @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,10);

        List<MyPic> pageList = picService.MyPicList();

        PageInfo<MyPic> picSelectInfo = new PageInfo<>(pageList);

        picSelectInfo.getList();//这里步没有问题

        model.addAttribute("picSelectInfo",picSelectInfo);

        return "picwall";
    }

    @RequestMapping("/picSelect")
    public String picShow(Model model,
                  @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                  @RequestParam("typeToType")  String typeName){

        PageHelper.startPage(pageNum,10);

        List<MyPic> pageList = picService.PicTypeList(typeName);

        PageInfo<MyPic> picSelectInfo = new PageInfo<>(pageList);

        picSelectInfo.getList();//这里步没有问题

        model.addAttribute("picSelectInfo",picSelectInfo);

        return "picwall";
    }
}
