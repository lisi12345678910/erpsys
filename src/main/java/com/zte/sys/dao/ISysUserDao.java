package com.zte.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zte.sys.model.Job;
import com.zte.sys.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysUserDao extends BaseMapper<Users> {
    List<Users> userlist(Users users);

}
