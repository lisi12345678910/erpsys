package com.zte.sys.control;


import com.zte.common.model.Job;
import com.zte.logaop.Log;
import com.zte.sys.model.Dept;

import com.zte.sys.model.Users;
import com.zte.sys.service.ISysUserService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SysUserAction {

    @Autowired
    private ISysUserService userService;



    /**
     * userlist ajx数据返回
     *
     * @return
     */
    @RequestMapping("/userlist")
    @ResponseBody
    @Log(value = "25",action = "查询用户列表")
    public ResultMessage userlist(Users users, PageModel<Users> pageModel) {


        PageModel<Users> pageModel1 = userService.userlist(users, pageModel);

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

    @RequestMapping("/usersjobslist")
    @ResponseBody

    public ResultMessage simplejobslist(Job job) {
        List<Job> jobsList = null;
        if (job.getJobDeptId()!=null) {
            jobsList = userService.simplejobslist(job);
        }
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(jobsList);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加用户
     *
     * @param users
     * @return
     */
    @RequestMapping("/usersadd")
    @ResponseBody

    public ResultMessage usersadd(Users users) {
        Boolean aBoolean = userService.usersadd(users);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加页面请求
     *
     * @return
     */
    @RequestMapping("/addusers")
    @Log(value = "25",action = "添加员工")
    public String addusers() {
        return "sys/users/userAdd";
    }


    //修改

    /**
     * 修改页面请求
     *
     * @return
     */
    @RequestMapping("/userupdate/{uId}")
    public String userupdate(@PathVariable Integer uId, Model model) {



        Users users = userService.getById(uId);
        //获取所有职位
        List<Job> jobslist = userService.simplejobslist(null);

        //获取所有部门
        List<Dept> deptlist = userService.simpledeptlist();
        model.addAttribute("userview", users);
        model.addAttribute("deptlist", deptlist);
        model.addAttribute("joblist", jobslist);

        return "sys/users/userUpdate";
    }


    /**
     * 员工离职
     *
     * @param uId
     * @return
     */
    @RequestMapping("/updatestatus")
    @ResponseBody
    @Log(value = "25",action = "离职员工")
    public ResultMessage updatestatus(Integer uId) {
        Boolean aBoolean = userService.updatestatus(uId);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 执行修改
     *
     * @param users
     * @return
     */
    @RequestMapping("/updateuser")
    @ResponseBody
    @Log(value = "25",action = "修改员工信息")
    public ResultMessage updateuser(Users users) {
        Boolean aBoolean = userService.updateuser(users);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }
    //查看

    /**
     * 查看页面请求
     *
     * @return
     */
    @RequestMapping("/userView/{uid}/{pageNum}")
    @Log(value = "25",action = "查看详情")
    public String userView(@PathVariable Integer uid,@PathVariable Integer pageNum, Model model,HttpServletRequest request) {

        request.getSession().setAttribute("pagmm",pageNum);

        Users users1 = userService.finduser(uid);

        model.addAttribute("userview", users1);

        return "sys/users/userView";
    }


    /**
     * 查部门对应职业
     * @return
     */
    @RequestMapping("/queryjobs")
    @ResponseBody
    public ResultMessage queryjobs(Integer deptId) {
        List<Job> jobList =userService.queryjobs(deptId);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(jobList);
        resultMessage.setMsg("查询成功");
        return resultMessage;

    }
}

