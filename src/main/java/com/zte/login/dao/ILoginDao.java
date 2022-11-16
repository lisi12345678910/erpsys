package com.zte.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ILoginDao{
    LoginUser queryUserByCondition(LoginUserCondition condition);
    List<Integer> queryPermissionByJob(LoginUser loginUser);
}
