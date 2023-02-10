package com.zte.sys.dao;

import com.zte.sys.model.Journal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISysJournalDao {

    List<Journal> journallist(Journal journal);

    Journal findjournal(@Param("jId") Integer jId);

    Boolean creatjournal(Journal journal);
}
