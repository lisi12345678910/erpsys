package com.zte.sys.control;


import com.zte.sys.model.City;
import com.zte.sys.model.Dept;
import com.zte.sys.model.Users;
import com.zte.sys.service.ISysCityService;
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
public class SysCityAction {

    @Autowired
    private ISysCityService cityService;
    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 区域数据展示
     * @param city
     * @param pageModel
     * @return
     */
    @RequestMapping("/arealist")
    @ResponseBody
    public ResultMessage arealist(City city, PageModel<City> pageModel){
        PageModel<City> pageModel1 =cityService.arealist(city,pageModel);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }


}

