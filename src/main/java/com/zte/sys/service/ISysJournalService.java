package com.zte.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zte.sys.model.Journal;
import com.zte.sys.model.Users;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysJournalService {

    PageModel<Journal> journallist(Journal journal, PageModel<Journal> pageModel);
}
