package com.zte.login.service.impl;

import com.zte.login.dao.ILoginDao;
import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import com.zte.login.model.Module;
import com.zte.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private ILoginDao iLoginDao;

    @Override
    public LoginUser queryUserByCondition(LoginUserCondition condition) {
        LoginUser loginUser = iLoginDao.queryUserByCondition(condition);
        return loginUser;
    }

    @Override
    public List<Module> queryPermissionByJob(LoginUser loginUser) {
        List<Module> list = iLoginDao.queryPermissionByJob(loginUser);
        return list;
    }
}
