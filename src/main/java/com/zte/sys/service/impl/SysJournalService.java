package com.zte.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.sys.dao.ISysJournalDao;
import com.zte.sys.model.Journal;
import com.zte.sys.service.ISysJournalService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysJournalService implements ISysJournalService {
    @Autowired
    private ISysJournalDao journalDao;

    @Override
    public PageModel<Journal> journallist(Journal journal,PageModel<Journal> pageModel) {
        //--------------------------------------
        int pageNum = pageModel.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;

        int pageSize = pageModel.getPageSize();
        pageSize = pageSize <= 0 ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //---------------------------------------
        List<Journal> journalList =  journalDao.journallist(journal);
        PageInfo<Journal> usersPageInfo = new PageInfo<>(journalList);
        //----------------------------------------
        pageModel.setPageSize(usersPageInfo.getPageSize());
        pageModel.setTotalPage(usersPageInfo.getPages());
        pageModel.setTotalCount((int) usersPageInfo.getTotal());
        pageModel.setPageNum(usersPageInfo.getPageNum());
        pageModel.setData(usersPageInfo.getList());
        //---------------------------------------
        return pageModel;
    }

    @Override
    public Journal findjournal(Integer jId) {
        Journal journal = journalDao.findjournal(jId);
        return journal;
    }

    @Override
    public Boolean creatjournal(Journal journal) {
        Boolean b = journalDao.creatjournal(journal);
        return b;
    }
}
