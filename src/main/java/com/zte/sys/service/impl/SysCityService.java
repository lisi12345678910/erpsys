package com.zte.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.sys.dao.ISysCityDao;
import com.zte.sys.model.City;
import com.zte.sys.model.Job;
import com.zte.sys.model.Users;
import com.zte.sys.dao.ISysUserDao;

import com.zte.sys.service.ISysCityService;
import com.zte.sys.service.ISysUserService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCityService implements ISysCityService {
    @Autowired
    private ISysCityDao sysCityDao;

    @Override
    public PageModel<City> arealist(City city, PageModel<City> pageModel) {
        //--------------------------------------
        int pageNum = pageModel.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;

        int pageSize = pageModel.getPageSize();
        pageSize = pageSize <= 0 ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //---------------------------------------
        List<City> cityList = sysCityDao.arealist(city);
        PageInfo<City> usersPageInfo = new PageInfo<>(cityList);
        //----------------------------------------
        pageModel.setPageSize(usersPageInfo.getPageSize());
        pageModel.setTotalPage(usersPageInfo.getPages());
        pageModel.setTotalCount((int) usersPageInfo.getTotal());
        pageModel.setPageNum(usersPageInfo.getPageNum());
        pageModel.setData(usersPageInfo.getList());
        //---------------------------------------
        return pageModel;
    }
}
