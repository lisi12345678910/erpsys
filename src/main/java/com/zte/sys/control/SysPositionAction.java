package com.zte.sys.control;


import com.zte.sys.model.Dept;
import com.zte.sys.model.Job;
import com.zte.sys.model.Users;
import com.zte.sys.service.ISysPositionService;
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
public class SysPositionAction {

    @Autowired
    private ISysPositionService positionService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 职位鼓励页面请求
     * @return
     */
    @RequestMapping("/sys/position/positionList")
    private String positionlistView(){
        return "sys/position/positionList";
    }


    @RequestMapping("/positionlist")
    @ResponseBody
    private ResultMessage positionlist(Job job, PageModel<Job> pageModel){
        PageModel<Job> pageModel1 = positionService.positionlist(job,pageModel);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }
    @RequestMapping("/positionsdeptlist")
    @ResponseBody
    private ResultMessage positionsdeptlist(){
        List<Dept> deptList = positionService.positionsdeptlist();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(deptList);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }
}

