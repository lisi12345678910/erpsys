package com.zte.sys.service;

import com.zte.sys.model.Dept;
import com.zte.sys.model.Job;
import com.zte.sys.model.Users;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysPositionService {

    PageModel<Job> positionlist(Job job, PageModel<Job> pageModel);

    List<Dept> positionsdeptlist();
}
