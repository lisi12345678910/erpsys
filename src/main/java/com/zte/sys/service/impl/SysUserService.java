package com.zte.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.sys.dao.ISysDeptDao;
import com.zte.sys.model.Dept;
import com.zte.sys.model.Users;
import com.zte.sys.dao.ISysUserDao;

import com.zte.sys.service.ISysDeptService;
import com.zte.sys.service.ISysUserService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class SysUserService  extends ServiceImpl<ISysUserDao,Users> implements ISysUserService {
    @Autowired
    private ISysUserDao iSysUserDao;
    @Autowired
    private ISysDeptDao deptDao;



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

//    @RequestMapping("/addusers")
//    public String addusers(){
//        return "userAdd";
//    }

}
