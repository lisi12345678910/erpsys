package com.zte.sys.control;


import com.zte.sys.model.Dept;
import com.zte.sys.model.Users;
import com.zte.sys.service.ISysUserService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysUserAction {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * userlist ajx数据返回
     *
     * @return
     */
    @RequestMapping("/userlist")
    @ResponseBody
    public ResultMessage userlist(Users users,PageModel<Users> pageModel) {
        PageModel<Users> pageModel1 = userService.userlist(users,pageModel);

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;

    }
    @RequestMapping("/usersdeptlist")
    @ResponseBody
    public ResultMessage simpledeptlist() {
        List<Dept> usersList = userService.simpledeptlist();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(usersList);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加页面请求
     * @return
     */
    @RequestMapping("/addusers")
    public String addusers(){
        return "/sys/users/userAdd";
    }


}

