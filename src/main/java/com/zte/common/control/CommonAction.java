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


    /**
     * 登录界面
     *
     * @return "login"
     */
    @RequestMapping("/loginView")
    public String loginView() {
        return "login";
    }

    @RequestMapping("/top")
    public String top() {
        return "top";
    }

    @RequestMapping("/left")
    public String left() {
        return "left";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/footer")
    public String footer() {
        return "footer";
    }

    @RequestMapping("/main")
    public String home() {
        return "main";
    }

    @RequestMapping("/tools")
    public String tools() {
        return "tools";
    }

}
