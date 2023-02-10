package com.zte.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.common.model.City;
import com.zte.common.model.Province;
import com.zte.sys.dao.ISysCityDao;
import com.zte.sys.dao.ISysDeptDao;

import com.zte.sys.model.Dept;

import com.zte.sys.service.ISysDeptService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptService implements ISysDeptService {
    @Autowired
    private ISysDeptDao iSysDeptDao;

    @Autowired
    private ISysCityDao cityDao;

    @Override
    public PageModel<Dept> deptlist(Dept dept, PageModel<Dept> pageModel) {

        int pageNum = pageModel.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;
        int pageSize = pageModel.getPageSize();
        pageSize = pageSize <= 0 ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);

        List<Dept> deptsList = iSysDeptDao.deptlist(dept);
        PageInfo<Dept> usersPageInfo = new PageInfo<>(deptsList);

        pageModel.setPageSize(usersPageInfo.getPageSize());
        pageModel.setTotalPage(usersPageInfo.getPages());
        pageModel.setTotalCount((int) usersPageInfo.getTotal());
        pageModel.setPageNum(usersPageInfo.getPageNum());
        pageModel.setData(usersPageInfo.getList());

        return pageModel;
    }

    @Override
    public List<Province> deptProvincelist() {
        List<Province> provinceList = cityDao.deptProvincelist();
        return provinceList;
    }

    @Override
    public List<City> deptcitylist(City city) {
       List<City> cityList = cityDao.deptcitylist(city);
       return cityList;
    }

    @Override
    public Boolean deptadd(Dept dept) {
        Boolean b = iSysDeptDao.deptadd(dept);
        return b;
    }

    @Override
    public Dept finddept(Integer deptId) {
        Dept dept = iSysDeptDao.finddept(deptId);
        return dept;
    }

    @Override
    public Boolean updatedept(Dept dept) {
        Boolean b = iSysDeptDao.updatedept(dept);
        return b;
    }

    @Override
    public Boolean updatedeptstatus(Integer uId) {
       Boolean b = iSysDeptDao.updatedeptstatus(uId);
       return b;
    }

    @Override
    public Dept haveornodept(String deptName) {
        Dept dept = iSysDeptDao.haveornodept(deptName);
        return dept;
    }
}
