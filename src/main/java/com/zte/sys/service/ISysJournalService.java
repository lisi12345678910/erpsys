package com.zte.sys.service;

import com.zte.sys.model.Journal;
import com.zte.util.PageModel;

public interface ISysJournalService {

    PageModel<Journal> journallist(Journal journal, PageModel<Journal> pageModel);

    Journal findjournal(Integer jId);

    Boolean creatjournal(Journal journal);
}
