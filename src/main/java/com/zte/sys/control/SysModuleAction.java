package com.zte.sys.control;


import com.zte.logaop.Log;
import com.zte.login.model.Module;
import com.zte.sys.service.ISysModuleService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysModuleAction {

    @Autowired
    private ISysModuleService moduleService;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 模块列表
     * @param module
     * @param pageModel
     * @return
     */
    @RequestMapping("/modulelist")
    @ResponseBody
//    @Log(value = "28",action = "查询模块列表")
    public ResultMessage moduleList(Module module, PageModel<Module> pageModel){
        PageModel<Module> pageModel1 = moduleService.modulelist(module,pageModel);

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 简单父模块列表
     * @return
     */
    @RequestMapping("/simplefathermodulelist")
    @ResponseBody
    public ResultMessage simplefathermodulelist(){

        List<Module> moduleList = moduleService.simplefathermodulelist();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(moduleList);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加模块
     * @param
     * @return
     */
    @RequestMapping("/moduleadd")
    @ResponseBody
//    @Log(value = "28",action = "添加模块")
    public ResultMessage moduleadd(Module module) {
        Boolean aBoolean = moduleService.moduleadd(module);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加页面请求
     * @return
     */
    @RequestMapping("/addmodule")
    public String addposition(){
        return "sys/modules/moduleAdd";
    }


    //修改
    /**
     * 修改页面请求
     * @param moduleId
     * @param model
     * @return
     */
    @RequestMapping("/moduleUpdate/{moduleId}")
    public String moduleUpdate(@PathVariable Integer moduleId, Model model){
        Module module = moduleService.findmodule(moduleId);

        List<Module> simplefathermodulelist = moduleService.simplefathermodulelist();
        model.addAttribute("moduleview",module);
        model.addAttribute("fathermodeule",simplefathermodulelist);
        return "sys/modules/moduleUpdate";
    }

    /**
     * 执行修改
     * @param module
     * @return
     */
    @RequestMapping("/updatemodule")
    @ResponseBody
//    @Log(value = "28",action = "修改模块信息")
    public ResultMessage updatemodule(Module module){
        Boolean aBoolean = moduleService.updatemodule(module);
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
    @RequestMapping("/moduleView/{moduleId}")
//    @Log(value = "28",action = "查看模块详情")
    public String userView(@PathVariable Integer moduleId, Model model) {

        Module module = moduleService.findmodule(moduleId);

//        LambdaQueryWrapper<Users> lqw = new LambdaQueryWrapper();
//        lqw.eq(uId!=null,Users::getUId, uId);
//
//        List<Users> list = userService.list(lqw);

        model.addAttribute("moduleview", module);

        return "sys/modules/moduleView";
    }


    /**
     * 模块注销
     *
     * @param mId
     * @return
     */
    @RequestMapping("/updatemodulestatus")
    @ResponseBody
//    @Log(value = "28",action = "改变模块状态")
    public ResultMessage updatemodulestatus(Integer mId) {
        System.out.println(mId);
        Boolean aBoolean = moduleService.updatemodulestatus(mId);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     *
     *
     * @param moduleRname
     * @return
     */
    @RequestMapping("/haveornomodule")
    @ResponseBody
    public Module haveornomodule(String moduleRname) {
        Module module = moduleService.haveornomodule(moduleRname);
        return module;
    }
}

