package com.jcn.service.impl;

import com.jcn.dao.MyAdminDao;
import com.jcn.dao.MySaltDao;
import com.jcn.entity.MyAdmin;
import com.jcn.exception.GlobalException;
/*import com.jcn.redis.key.MyAdminKey;
import com.jcn.redis.service.RedisService;*/
import com.jcn.result.MywebCodeMsg;
import com.jcn.service.api.LoginService;
import com.jcn.utils.MD5Util;
/*import com.jcn.utils.UUIDUtil;*/
import com.jcn.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import javax.servlet.http.Cookie;*/
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MyAdminDao myAdminDao;

    @Autowired
    private MySaltDao mySaltDao;

    /*@Autowired
    private RedisService redisService;*/


    @Override
    public MyAdmin getByAcct(String loginAcct) {
        /*//1、先从缓存中取，看有没有先
        //问题在这里
        MyAdmin myAdmin = redisService.get(MyAdminKey.getByAcct,""+loginAcct,MyAdmin.class);
        if (myAdmin != null){
            return myAdmin;
        }else {
            //2、从数据库取
            myAdmin = myAdminDao.getByAcct(loginAcct);
            if (myAdmin != null){
                //3、如果获取的对象不为空，将对象写入redis中
                redisService.set(MyAdminKey.getByAcct,""+loginAcct,myAdmin);
            }
            return myAdmin;
        }*/

        MyAdmin myAdmin = myAdminDao.getByAcct(loginAcct);

        return myAdmin;
    }

    //登陆并生成token，写入cookie，再返回token
    public String login(HttpServletResponse response, LoginVo loginVo){

        //1、判断loginVo是否为空
        if (loginVo == null){
            throw new GlobalException(MywebCodeMsg.SERVER_ERROR);
        }
        //2、获取表单：账号和密码
        String acct = loginVo.getAcct();
        String formPassword = loginVo.getPassword();
        //3、验证账号存不存在,看看能不能在数据库中根据账号来获取用户
        MyAdmin myAdmin = getByAcct(acct);
        System.out.println(myAdmin);
        if (myAdmin == null){
            throw new GlobalException(MywebCodeMsg.ACCT_NOT_EXIST);
        }
        //4、验证密码，两次MD5:获取dbPass
        String dbPass = myAdmin.getLoginPass();
        //设置盐值
        String salt = mySaltDao.getMySalt();
        String calcPass = MD5Util.formPassToDBPass(formPassword, salt);
        if (!calcPass.equals(dbPass)){
            throw new GlobalException(MywebCodeMsg.PASSWORD_ERROR);
        }

        /*//5、生成token
        String token = UUIDUtil.uuid();
        System.out.println(token);
        //6、存入cookie
        addCookie(response, token, myAdmin);

        return token;*/
        return "success";
    }

    /*private void addCookie(HttpServletResponse response, String token, MyAdmin myAdmin) {
        //将用户信息存入redis中
        //user:用户信息，以后拿到token就能知道用户信息
        redisService.set(MyAdminKey.getByAcct,token,myAdmin);
        //生成cookie
        Cookie cookie = new Cookie("COOKI_NAME_TOKEN",token);
        //设置cookie有效期与session保持一致（SflashUserKey.token）
        cookie.setMaxAge(MyAdminKey.token.expireSeconds());
        //设置网站根目录
        cookie.setPath("/");
        //生成完后写入到response里面，将cookie写入客户端
        response.addCookie(cookie);
    }*/

}
