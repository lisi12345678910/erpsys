package com.zte.sys.control;


import com.zte.sys.model.Job;
import com.zte.login.model.Module ;

import com.zte.sys.model.Users;
import com.zte.sys.service.ISysModuleService;
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
public class SysModuleAction {

    @Autowired
    private ISysModuleService moduleService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/modulelistView")
    public String modulelistView(){
        return "sys/modules/moduleList";
    }

    @RequestMapping("/modulelist")
    @ResponseBody
    public ResultMessage moduleList(Module module, PageModel<Module> pageModel){
        PageModel<Module> pageModel1 = moduleService.modulelist(module,pageModel);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

}

