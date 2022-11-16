package com.zte.login.control;


import com.zte.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    @Autowired
    private ILoginService userService;
    @Autowired
    private RedisTemplate redisTemplate;






}

