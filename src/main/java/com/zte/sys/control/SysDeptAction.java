package com.zte.sys.control;


import com.zte.sys.model.City;
import com.zte.sys.model.Dept;
import com.zte.sys.model.Province;
import com.zte.sys.model.Users;
import com.zte.sys.service.ISysDeptService;
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


}

