package com.zte.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zte.user.model.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao extends BaseMapper<Users> {
}
