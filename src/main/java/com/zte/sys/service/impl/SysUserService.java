package com.zte.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.common.model.Job;
import com.zte.sys.dao.ISysDeptDao;
import com.zte.sys.dao.ISysPositionDao;
import com.zte.sys.dao.ISysUserDao;
import com.zte.sys.model.Dept;

import com.zte.sys.model.Users;
import com.zte.sys.service.ISysUserService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysUserService  extends ServiceImpl<ISysUserDao,Users> implements ISysUserService {
    @Autowired
    private ISysUserDao iSysUserDao;
    @Autowired
    private ISysDeptDao deptDao;
    @Autowired
    private ISysPositionDao positionDao;


    @Override
    public PageModel<Users> userlist(Users users, PageModel<Users> pageModel) {
        //--------------------------------------
        int pageNum = pageModel.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;

        int pageSize = pageModel.getPageSize();
        pageSize = pageSize <= 0 ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //---------------------------------------

        List<Users> usersList = iSysUserDao.userlist(users);
        PageInfo<Users> usersPageInfo = new PageInfo<>(usersList);
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
    public List<Dept> simpledeptlist() {
        List<Dept> deptList = deptDao.simpledeptlist();
        return deptList;
    }

    @Override
    public List<Job> simplejobslist(Job job) {
        List<Job> jobList= positionDao.simplejobslist(job);
        return jobList;
    }

    @Override
    public Boolean usersadd(Users users) {
        users.setStatusId(1);
        users.setHiredate(new Date());
        Boolean b = iSysUserDao.usersadd(users);
        return b;
    }

    @Override
    public Boolean updatestatus(Integer uId) {
        Boolean b = iSysUserDao.updatestatus(uId);
        Boolean b1 = iSysUserDao.insertleavedate(uId,new Date());
        return b==b1;

    }

    @Override
    public Users finduser(Integer uId) {
        Users users = iSysUserDao.finduser(uId);
//        iSysUserDao.finduser()
        return users;
    }

    @Override
    public Boolean updateuser(Users users) {
        Boolean b = iSysUserDao.updateuser(users);
        return b;
    }

    @Override
    public List<Job> queryjobs(Integer deptId) {
        List<Job> jobList = positionDao.queryjobs(deptId);
        return jobList;
    }


}
