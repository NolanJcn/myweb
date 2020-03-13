package com.jcn.controller;

import com.jcn.exception.GlobalException;
import com.jcn.result.MywebCodeMsg;
import com.jcn.service.impl.PicServiceImpl;
import com.jcn.utils.MyWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PicServiceImpl picService;

    //图片上传
    @RequestMapping("/upload")
    public String picUpload(@RequestParam("file") MultipartFile file,
                                         HttpServletRequest request){

        //先判断是否为空
        if (file.isEmpty()){

            throw new GlobalException(MywebCodeMsg.PIC_NULL_ERROR);

        }

        //获取上传图片名称
        String fileName = file.getOriginalFilename();

        //再判断文件格式
        if(!MyWebUtils.isPicFile(fileName)){

            throw new GlobalException(MywebCodeMsg.PIC_FORMAT_ERROR);

        }

        //根据浏览器获取文件名称
        fileName = MyWebUtils.isBrowser(fileName);

        //拼接图片名称生成图片路径
        String filePath = "E:/github仓库/myweb/src/main/resources/static/img/home/"+fileName;

        //将图片保存到系统
        File picFile = new File(filePath);

        //获取图片分类
        Integer typeId = Integer.valueOf(request.getParameter("select"));

        if (typeId == null){

            throw new GlobalException(MywebCodeMsg.PIC_TYPE_NULL_ERROR);

        }

        //获取图片名称
        String picName = request.getParameter("pname");

        if (!MyWebUtils.strIfEffective(picName)){

            throw new GlobalException(MywebCodeMsg.PIC_NAME_NULL_ERROR);

        }

        try {

            file.transferTo(picFile);

            LOGGER.info("上传成功");

            //我们需要保存图片路径（/img/home/fileName）到数据库里
            picService.savePic(picFile,typeId,picName);

            return "redirect:/home?pageNum=999999";

        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }

        throw new GlobalException(MywebCodeMsg.PIC_ERROR);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 500){
            return "/error/500";
        }else{
            return "redirect:/home";
        }

    }
}
