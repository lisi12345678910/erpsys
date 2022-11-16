package com.zte.common.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonAction {

    /**
     * 登录界面
     * @return "login"
     */
    @RequestMapping("/login")
    public String index(){

        return "login";
    }
    @RequestMapping("/main")
    public String home(){

        return "main";
    }

}
