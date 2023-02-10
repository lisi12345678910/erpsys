package com.zte.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zte.sys.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ISysUserDao extends BaseMapper<Users> {
    List<Users> userlist(Users users);

    Boolean usersadd(Users users);

    Boolean updatestatus(@Param("uId") Integer uId);

    Boolean insertleavedate(@Param("uIde") Integer uId, @Param("date") Date date);

    Users finduser(@Param("uId") Integer uId);

    Boolean updateuser(Users users);
}
