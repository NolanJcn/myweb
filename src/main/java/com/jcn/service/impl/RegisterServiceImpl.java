package com.jcn.service.impl;

import com.jcn.dao.MyAdminDao;
import com.jcn.dao.MySaltDao;
import com.jcn.entity.MyAdmin;
import com.jcn.exception.GlobalException;
import com.jcn.result.MywebCodeMsg;
import com.jcn.service.api.RegisterService;
import com.jcn.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private MyAdminDao myAdminDao;

    @Autowired
    private MySaltDao mySaltDao;

    @Override
    public boolean insertMyAdmin(String acct,String pass,String username,String email) {

        MyAdmin myAdmin = new MyAdmin();

        myAdmin.setLoginAcct(acct);

        myAdmin.setUserName(username);

        myAdmin.setEmail(email);

        //判断账号是否被注册过
        if ((myAdminDao.getByAcct(acct)) != null){
            throw new GlobalException(MywebCodeMsg.REGISTER_ACCT_ERROR);
        }

        //加密
        String salt = mySaltDao.getMySalt();

        String registerDBPass = MD5Util.inputPassToDbPass(pass,salt);

        myAdmin.setLoginPass(registerDBPass);

        //生成注册时间
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        myAdmin.setCreateTime(df.format(day));

        return myAdminDao.insertMyAdmin(myAdmin);
    }

}
