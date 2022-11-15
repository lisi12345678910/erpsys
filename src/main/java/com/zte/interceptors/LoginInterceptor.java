package com.zte.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // HttpSession session = request.getSession();
        Object loginUser = redisTemplate.opsForValue().get("loginUser");
        if(loginUser!=null){
            return true;
        }else{
            ResultMessage rm = new ResultMessage();
            rm.setStatus("201");
            rm.setFlag(false);
            rm.setMsg("未登录！");

            ObjectMapper m = new ObjectMapper();
            String json = m.writeValueAsString(rm);

            response.setContentType("application/json;charset=utf8");

            response.getWriter().write(json);
            return false;
        }
    }

}
