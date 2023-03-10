package com.zte.login.control;


import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import com.zte.login.model.Module;
import com.zte.login.service.ILoginService;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserAction {

    @Autowired
    private ILoginService iLoginService;
    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/login")
    @ResponseBody
    public ResultMessage login(LoginUserCondition condition, String remember, HttpServletResponse response){
        LoginUser loginUser = iLoginService.queryUserByCondition(condition);
        ResultMessage rm = new ResultMessage();

        if (loginUser!=null){
            if (loginUser.getStatusId() == 1){
                List<Module> list = iLoginService.queryPermissionByJob(loginUser);

                if (list!=null){
                    loginUser.setModules(list);
                }

                redisTemplate.opsForValue().set("loginUser",loginUser);

                rm.setStatus("200");
                rm.setFlag(true);
                rm.setMsg("登录成功！");
                if (remember!=null && "on".equals(remember)){
                    Cookie cookie1 = new Cookie("username", condition.getUname());
                    Cookie cookie2 = new Cookie("password", condition.getUpassword());
                    cookie1.setMaxAge(60*60*24);
                    cookie2.setMaxAge(60*60*24);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
            }else {
                rm.setStatus("401");
                rm.setFlag(false);
                rm.setMsg("登录失败，该用户已离职！");
            }
        }else {
            rm.setStatus("404");
            rm.setFlag(false);
            rm.setMsg("登录失败，用户名或密码错误！");
        }


        return rm;
    }

    @RequestMapping("/loginBack")
    @ResponseBody
    public LoginUserCondition loginBack(HttpServletRequest request) {
        LoginUserCondition condition = new LoginUserCondition();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())){
                    condition.setUname(cookie.getValue());
                }
                if ("password".equals(cookie.getName())){
                    condition.setUpassword(cookie.getValue());
                }
            }
        }
        return condition;
    }
    @RequestMapping("/loginName")
    @ResponseBody
    public LoginUser loginName() {
        LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get("loginUser");
        return loginUser;
    }

    @RequestMapping("/loginExit")
    public String loginExit() {
        redisTemplate.delete("loginUser");
        return "login";
    }

    @RequestMapping("/loginPermission")
    @ResponseBody
    public List<Module> loginPermission() {
        LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get("loginUser");
        List<Module> modules = loginUser.getModules();
        return modules;
    }

}

