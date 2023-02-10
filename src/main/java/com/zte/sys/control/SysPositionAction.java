package com.zte.sys.control;


import com.zte.common.model.Job;
import com.zte.logaop.Log;
import com.zte.login.model.Module;
import com.zte.sys.model.Dept;

import com.zte.sys.service.ISysPositionService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class SysPositionAction {

    @Autowired
    private ISysPositionService positionService;
    @Autowired
    private RedisTemplate redisTemplate;




    @RequestMapping("/positionlist")
    @ResponseBody
//    @Log(value = "27",action = "查询职位列表")
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

    /**
     * 添加职位
     * @param
     * @return
     */
    @RequestMapping("/positionadd")
    @ResponseBody
//    @Log(value = "27",action = "添加职位")
    public ResultMessage positionadd(Job job) {
        Boolean aBoolean = positionService.positionadd(job);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加页面请求
     * @return
     */
    @RequestMapping("/addposition")
    public String addposition(){
        return "sys/position/positionAdd";
    }

    //修改
    /**
     * 修改页面请求
     * @param jobId
     * @param model
     * @return
     */
    @RequestMapping("/positionUpdate/{jobId}")
    public String deptUpdate(@PathVariable Integer jobId, Model model){
        Job job = positionService.findjob(jobId);

        List<Dept> positionsdeptlist = positionService.positionsdeptlist();
        model.addAttribute("jobview",job);
        model.addAttribute("deptlist",positionsdeptlist);
        return "sys/position/positionUpdate";
    }

    /**
     * 执行修改
     * @param job
     * @return
     */
    @RequestMapping("/updateposition")
    @ResponseBody
//    @Log(value = "27",action = "修改职位信息")
    public ResultMessage updateposition(Job job){
        Boolean aBoolean = positionService.updateposition(job);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    //赋权
    /**
     * 赋权页面请求
     * @param jobId
     * @param model
     * @return
     */
    @RequestMapping("/positionGrant/{jobId}")
    public String positionGrant(@PathVariable Integer jobId,Model model){
        //查父模块
        List<Module> moduleList = positionService.fathermoduleList(jobId);
        //职业拥有的权限
        for (Module module : moduleList) {
            System.out.println(module.getIsper());
        }

        model.addAttribute("moduleList",moduleList);
        model.addAttribute("jobId",jobId);
        return "sys/position/positionGrant";
    }

    /**
     * 执行赋权
     * @param
     * @return
     */
    @RequestMapping("/updategrant")
    @ResponseBody
//    @Log(value = "27",action = "职位赋权")
    public ResultMessage updategrant(Integer jobId,HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] ints = parameterMap.get("moduleId");//获取权限列表
        String[] jobids = parameterMap.get("jobId");//获取id

        Boolean aBoolean = positionService.updategrant(jobids[0],ints);
        ResultMessage resultMessage = new ResultMessage();
//        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 职位注销
     *
     * @param uId
     * @return
     */
    @RequestMapping("/updatepositionstatus")
    @ResponseBody
    @Log(value = "27",action = "改变职位状态")
    public ResultMessage updatepositionstatus(Integer uId) {
        Boolean aBoolean = positionService.updatepositionstatus(uId);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }
    /**
     * 职位注销
     *
     * @param jobName
     * @return
     */
    @RequestMapping("/haveornoposition")
    @ResponseBody
    public Job haveornoposition(String jobName) {
        Job job = positionService.haveornoposition(jobName);

        return job;
    }

}

