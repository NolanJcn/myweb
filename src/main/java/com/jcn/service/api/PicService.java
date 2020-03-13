package com.jcn.service.api;

import com.jcn.entity.MyPic;

import java.io.File;
import java.util.List;

public interface PicService {

    MyPic savePic(File picFile, Integer typeId,String picName);

    List<MyPic> MyPicList();

    List<MyPic> PicTypeList(String typeName);
}
