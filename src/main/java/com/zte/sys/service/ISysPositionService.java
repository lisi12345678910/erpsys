package com.zte.sys.service;

import com.zte.common.model.Job;
import com.zte.login.model.Module;
import com.zte.sys.model.Dept;

import com.zte.util.PageModel;

import java.util.List;

public interface ISysPositionService {

    PageModel<Job> positionlist(Job job, PageModel<Job> pageModel);

    List<Dept> positionsdeptlist();

    Boolean positionadd(Job job);

    Job findjob(Integer jobId);

    Boolean updateposition(Job job);

    List<Module> moduleList();

    List<Module> fathermoduleList(Integer integer);

    Boolean updategrant(String jobid,String[] strings);

    Boolean updatepositionstatus(Integer uId);

    Job haveornoposition(String jobName);
}
