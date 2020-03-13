package com.jcn.utils;

import com.alibaba.fastjson.JSON;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/***
 * 公共工具类
 */
public class MyWebUtils {

    //判断字符串是否有效
    public static boolean strIfEffective(String str){
        //是空字符串
        if ((str == null) || (str.length() <= 0)){
            return false;
        }

        //字符串有效
        return true;
    }

    //压制警告
    @SuppressWarnings("unchecked")
    //把字符串转化为bean对象
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if(!strIfEffective(str) || clazz == null) {
            return null;
        }
        //clazz如果是整型的话，就直接进行类型转化即可
        if(ClazzFor.clazzForInt(clazz)) {
            return (T)Integer.valueOf(str);
        }else if(ClazzFor.clazzForStr(clazz)) {
            return (T)str;
        }else if(ClazzFor.clazzForLong(clazz)) {
            return  (T)Long.valueOf(str);
        }else {
            //parseObject：将json字符串转换为bean对象
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    //将任意类型转化为字符串
    public static <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        //如果是int，long型，则直接写入，否则进行转型
        if(ClazzFor.clazzForInt(clazz)) {
            return ""+value;
        }else if(ClazzFor.clazzForStr(clazz)) {
            return (String)value;
        }else if(ClazzFor.clazzForLong(clazz)) {
            return ""+value;
        }else {
            //将bean对象转换为json字符串
            return JSON.toJSONString(value);
        }
    }

    //判断文件是否是图片
    //jpg、jpeg、tiff、png、gif、psd、raw、eps、svg、pdf、bmp
    public static boolean isPicFile(String fileName){

        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        List list = new ArrayList();

        list.add("jpg");list.add("jpeg");list.add("gif");list.add("tiff");
        list.add("png");list.add("psd");list.add("raw");list.add("eps");
        list.add("svg");list.add("pdf");list.add("bmp");

        int suffixIndex = list.indexOf(suffix);

        if (suffixIndex == -1){
            return false;
        }

        return true;
    }

    //根据浏览器类型获取我们需要的图片名称
    public static String isBrowser(String fileName){
        // 文件上传时，Chrome和IE/Edge对于originalFilename处理不同
        // Chrome 会获取到该文件的直接文件名称，IE/Edge会获取到文件上传时完整路径/文件名

        // Check for Unix-style path
        int unixSep = fileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = fileName.lastIndexOf('\\');
        // Cut off at latest possible point
        int pos = (winSep > unixSep ? winSep : unixSep);
        if (pos != -1)  {
            // Any sort of path separator found...
            fileName = fileName.substring(pos + 1);
        }
        return fileName;
    }

    //根据图片的地址，返回图片的缓冲流
    public static BufferedImage getInputStream(String addr){
        try {
            String imgPath = addr;
            BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
