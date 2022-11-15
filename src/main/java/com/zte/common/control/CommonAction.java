package com.zte.common.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonAction {

    @RequestMapping("/login")
    public String index(){
        return "login";
    }

}
