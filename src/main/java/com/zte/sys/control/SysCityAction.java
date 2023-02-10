package com.zte.sys.control;


import com.zte.common.model.City;

import com.zte.logaop.Log;
import com.zte.sys.service.ISysCityService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Log(value = "30",action = "查询区域列表")
    public ResultMessage arealist(City city, PageModel<City> pageModel){
        PageModel<City> pageModel1 =cityService.arealist(city,pageModel);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }


}

