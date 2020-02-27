package com.jcn.service.api;

import com.jcn.entity.MyAdmin;

public interface RegisterService {

     boolean insertMyAdmin(String acct,String pass,String username,String email);
}
