package com.zte.common.control;


import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import com.zte.login.service.ILoginService;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommonAction {

    @Autowired
    private ILoginService iLoginService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录界面
     * @return "login"
     */
    @RequestMapping("/loginView")
    public String loginView(){
        return "login";
    }

    @RequestMapping("/top")
    public String top(){
        return "top";
    }

    @RequestMapping("/left")
    public String left(){
        return "left";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/footer")
    public String footer(){
        return "footer";
    }

    @RequestMapping("/main")
    public String home(){
        return "main";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultMessage login(LoginUserCondition condition){
        LoginUser loginUser = iLoginService.queryUserByCondition(condition);
        ResultMessage rm = new ResultMessage();
        if (loginUser!=null){
            if (loginUser.getStatusId() == 1){
                List<Integer> list = iLoginService.queryPermissionByJob(loginUser);
                if (list!=null){
                    loginUser.setCompids(list);
                }
                redisTemplate.opsForValue().set("loginUser",loginUser);
                rm.setStatus("200");
                rm.setFlag(true);
                rm.setMsg("登录成功！");
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

}
