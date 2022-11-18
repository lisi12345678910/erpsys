package com.zte.sys.control;


import com.zte.sys.model.Journal;
import com.zte.sys.service.ISysJournalService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysJournalAction {

    @Autowired
    private ISysJournalService journalService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  日志页面请求
     * @return
     */
    @RequestMapping("/sys/logs/logList")
    private String loglistView(){
        return "sys/logs/logList";
    }

    /**
     *
     * @param journal
     * @param pageModel
     * @return
     */
    @RequestMapping("/loglist")
    @ResponseBody
    private ResultMessage loginlist(Journal journal, PageModel<Journal> pageModel){
        PageModel<Journal> pageModel1 = journalService.journallist(journal,pageModel);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultData(pageModel1);
        resultMessage.setMsg("查询成功");
        return resultMessage;
    }




}

