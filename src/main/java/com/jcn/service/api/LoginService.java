package com.jcn.service.api;

import com.jcn.entity.MyAdmin;

public interface LoginService {

    MyAdmin getByAcct(String acct);
}
