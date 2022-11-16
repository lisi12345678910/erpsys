package com.zte.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;

import java.util.List;

public interface ILoginService{
    LoginUser queryUserByCondition(LoginUserCondition condition);
    List<Integer> queryPermissionByJob(LoginUser loginUser);
}
