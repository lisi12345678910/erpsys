package com.zte.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zte.user.dao.IUserDao;
import com.zte.user.model.Users;
import com.zte.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<IUserDao, Users> implements IUserService{
}
