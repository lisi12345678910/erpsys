package com.zte.user.control;


import com.zte.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate redisTemplate;


}
