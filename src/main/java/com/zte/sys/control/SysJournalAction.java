package com.zte.sys.control;


import com.zte.logaop.Log;
import com.zte.sys.model.Journal;
import com.zte.sys.service.ISysJournalService;
import com.zte.util.PageModel;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysJournalAction {

    @Autowired
    private ISysJournalService journalService;
    @Autowired
    private RedisTemplate redisTemplate;



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


    //查看

    /**
     * 查看页面请求
     *
     * @return
     */
    @RequestMapping("/logView/{jId}")
    public String logView(@PathVariable Integer jId, Model model) {

        Journal journal = journalService.findjournal(jId);

        model.addAttribute("journalview", journal);

        return "sys/logs/logView";
    }

}

