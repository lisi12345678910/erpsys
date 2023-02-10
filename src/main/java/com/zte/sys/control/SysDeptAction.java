package com.zte.sys.control;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.zte.common.model.City;
import com.zte.common.model.Job;
import com.zte.common.model.Province;
import com.zte.logaop.Log;
import com.zte.sys.model.Dept;

import com.zte.sys.service.ISysDeptService;
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
public class SysDeptAction {

    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private RedisTemplate redisTemplate;





    /**
     * 部门数据
     * @param dept
     * @param pageModel
     * @return
     */
    @RequestMapping("/deptlist")
    @ResponseBody
    @Log(value = "26",action = "查询部门列表")
    public ResultMessage deptlist(Dept dept, PageModel<Dept> pageModel) {
        PageModel<Dept> pageModel1 =deptService.deptlist(dept,pageModel);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;

    }

    /**
     * 省份数据
     * @return
     */
    @RequestMapping("/deptProvincelist")
    @ResponseBody
    public ResultMessage deptProvincelist() {
        List<Province> provinceList =deptService.deptProvincelist();
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(provinceList);
        resultMessage.setMsg("查询成功");
        return resultMessage;

    }

    /**
     * 查所有城市
     * @return
     */
    @RequestMapping("/deptcitylist")
    @ResponseBody
    public ResultMessage deptcitylist(City city) {
        List<City> cityList =deptService.deptcitylist(city);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(cityList);
        resultMessage.setMsg("查询成功");
        return resultMessage;

    }
    @RequestMapping("/deptcitylist1")
    @ResponseBody
    public ResultMessage deptcitylist1(City city) {

        List<City> cityList = null;
        if (city.getPId()!=null) {
            cityList = deptService.deptcitylist(city);
        }

        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(cityList);
        resultMessage.setMsg("查询成功");
        return resultMessage;

    }

    /**
     * 添加部门
     * @param
     * @return
     */
    @RequestMapping("/deptadd")
    @ResponseBody
    @Log(value = "26",action = "添加部门")
    public ResultMessage deptadd(Dept dept) {
        Boolean aBoolean = deptService.deptadd(dept);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     * 添加页面请求
     * @return
     */
    @RequestMapping("/adddept")
    public String addusers(){
        return "sys/dept/deptAdd";
    }


    //修改
    /**
     * 修改页面请求
     * @param deptId
     * @param model
     * @return
     */
    @RequestMapping("/deptUpdate/{deptId}")
    public String deptUpdate(@PathVariable Integer deptId, Model model) throws JsonProcessingException {
        Dept dept = deptService.finddept(deptId);

        List<Province> provinceList = deptService.deptProvincelist();
        List<City> deptcitylist = deptService.deptcitylist(null);



        model.addAttribute("deptview",dept);
        model.addAttribute("provinceList",provinceList);
        model.addAttribute("cityList",deptcitylist);
        return "sys/dept/deptUpdate";
    }

    /**
     * 执行修改
     * @param dept
     * @return
     */
    @RequestMapping("/updatedept")
    @ResponseBody
    @Log(value = "26",action = "修改部门信息")
    public ResultMessage updatedept(Dept dept){
        Boolean aBoolean = deptService.updatedept(dept);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }


    /**
     *
     * @param uId
     * @return
     */
    @RequestMapping("/updatedeptstatus")
    @ResponseBody
    @Log(value = "26",action = "改变部门状态")
    public ResultMessage updatedeptstatus(Integer uId) {
        Boolean aBoolean = deptService.updatedeptstatus(uId);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(aBoolean);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }

    /**
     *
     * @param deptName
     * @return
     */
    @RequestMapping("/haveornodept")
    @ResponseBody
    public Dept haveornodept(String deptName) {
        Dept dept = deptService.haveornodept(deptName);

        return dept;
    }


}

