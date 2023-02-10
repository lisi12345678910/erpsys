package com.zte.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.common.model.Job;
import com.zte.login.model.Module;
import com.zte.sys.dao.ISysDeptDao;
import com.zte.sys.dao.ISysModuleDao;
import com.zte.sys.dao.ISysPositionDao;
import com.zte.sys.model.Dept;

import com.zte.sys.service.ISysPositionService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPositionService implements ISysPositionService {
    @Autowired
    private ISysPositionDao iSysPositionDao;
    @Autowired
    private ISysModuleDao moduleDao;
    @Autowired
    private ISysDeptDao deptDao;


    @Override
    public PageModel<Job> positionlist(Job job, PageModel<Job> pageModel) {
        //--------------------------------------
        int pageNum = pageModel.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;

        int pageSize = pageModel.getPageSize();
        pageSize = pageSize <= 0 ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //---------------------------------------
        List<Job> jobList = iSysPositionDao.positionlist(job);
        PageInfo<Job> usersPageInfo = new PageInfo<>(jobList);
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
    public List<Dept> positionsdeptlist() {
        List<Dept> deptlist = deptDao.simpledeptlist();
        return deptlist;
    }

    @Override
    public Boolean positionadd(Job job) {
        Boolean b = iSysPositionDao.positionadd(job);
        return b;
    }

    @Override
    public Job findjob(Integer jobId) {
        Job job = iSysPositionDao.findjob(jobId);
        List<Integer> integers = iSysPositionDao.getCompidList(job.getJobId());
        job.setCompidList(integers);
        return job;
    }

    @Override
    public Boolean updateposition(Job job) {
        Boolean b = iSysPositionDao.updateposition(job);
        return b;
    }

    @Override
    public List<Module> moduleList() {
        List<Module> modulelist = moduleDao.modulelist(null);
        return modulelist;
    }

    @Override
    public List<Module> fathermoduleList(Integer integer) {

        //所有父模块 及其所有的子模块
        List<Module> moduleList = moduleDao.simplefathermodulelist();
        for (Module module : moduleList) {
            List<Module> sonmoduleList = moduleDao.sonmodule(module.getModuleId());
            module.setSonlist(sonmoduleList);
        }
        //该职业及其权限列表并且转化为字符串
        List<Integer> integers = iSysPositionDao.getCompidList(integer);

        for (Module module : moduleList) {
            Integer moduleId = module.getModuleId();

            for (Integer integer1 : integers) {
                if (integer1.equals(moduleId)) {
                    module.setIsper(true);
                }
            }

            for (Module module1 : module.getSonlist()) {
                Integer moduleId1 = module1.getModuleId();

                for (Integer integer2 : integers) {
                    if (integer2.equals(moduleId1)) {
                        module1.setIsper(true);
                    }
                }
            }

        }

        return moduleList;
    }

    @Override
    public Boolean updategrant(String jobid,String[] strings) {
        //删除jobid的所有权限
        Boolean b = iSysPositionDao.updategrant1(jobid);
        //给jobid插入权限列表中的所有权限
        Boolean a = false;
        for (String s : strings) {
        a = iSysPositionDao.updategrant2(jobid,s);
        }
        return b==a;
    }

    @Override
    public Boolean updatepositionstatus(Integer uId) {
        Boolean b = iSysPositionDao.updatepositionstatus(uId);
        return b;
    }

    @Override
    public Job haveornoposition(String jobName) {
        Job job = iSysPositionDao.haveornoposition(jobName);
        return job;
    }

}
