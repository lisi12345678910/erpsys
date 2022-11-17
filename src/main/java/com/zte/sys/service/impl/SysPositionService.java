package com.zte.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.sys.dao.ISysDeptDao;
import com.zte.sys.dao.ISysPositionDao;
import com.zte.sys.dao.ISysUserDao;

import com.zte.sys.model.Dept;
import com.zte.sys.model.Job;
import com.zte.sys.model.Users;
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
}
