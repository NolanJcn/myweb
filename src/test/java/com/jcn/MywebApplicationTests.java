package com.jcn;

import com.jcn.dao.MySaltDao;
import com.jcn.service.impl.RegisterServiceImpl;
import com.jcn.utils.MyWebUtils;
import com.jcn.dao.MyAdminDao;
import com.jcn.entity.MyAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MywebApplicationTests {

    @Autowired
    private MyAdminDao myAdminDao;
    @Autowired
    private MySaltDao mySaltDao;

    @Autowired
    private RegisterServiceImpl registerService;

    @Test
    void contextLoads() {
        System.out.println(MyWebUtils.strIfEffective("ashvdvasdvas"));
    }

    @Test
    void insertMyAdmin() {
        myAdminDao.insertMyAdmin(new MyAdmin(1,"1","myweb","剑主","987639660@qq.com","null"));
    }

    @Test
    void getSalt(){
        String s = mySaltDao.getMySalt();
        System.out.println(s);
    }

    @Test
    void getAcct(){
        MyAdmin myAdmin = myAdminDao.getByAcct("jianzhu");
        System.out.println(myAdmin);
    }


}
