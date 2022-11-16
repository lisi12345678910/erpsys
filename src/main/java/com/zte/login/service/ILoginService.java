package com.zte.login.service;

import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import com.zte.login.model.Module;

import java.util.List;

public interface ILoginService{
    LoginUser queryUserByCondition(LoginUserCondition condition);
    List<Module> queryPermissionByJob(LoginUser loginUser);
}
