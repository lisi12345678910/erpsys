package com.zte.login.dao;

import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import com.zte.login.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ILoginDao{
    LoginUser queryUserByCondition(LoginUserCondition condition);
    List<Module> queryPermissionByJob(LoginUser loginUser);

}
