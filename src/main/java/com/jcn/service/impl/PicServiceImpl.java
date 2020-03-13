package com.jcn.service.impl;

import com.jcn.dao.MyPicDao;
import com.jcn.entity.MyPic;
import com.jcn.service.api.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class PicServiceImpl implements PicService {

    @Autowired
    private MyPicDao picDao;

    @Override
    public MyPic savePic(File picFile,Integer typeId,String picName) {

        MyPic myPic = new MyPic();

        myPic.setPicName(picName);
        myPic.setPicUrl("/img/home/"+picFile.getName());
        myPic.setTypeId(typeId);

        picDao.savePic(myPic);

        return myPic;
    }

    @Override
    public List<MyPic> MyPicList() {

        return picDao.MyPicList();
    }

    @Override
    public List<MyPic> PicTypeList(String typeName) {

        return picDao.picTypeList(typeName);
    }
}
