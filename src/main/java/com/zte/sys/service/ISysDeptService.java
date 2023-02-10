package com.zte.sys.service;

import com.zte.common.model.City;
import com.zte.common.model.Province;

import com.zte.sys.model.Dept;

import com.zte.util.PageModel;

import java.util.List;

public interface ISysDeptService {
    PageModel<Dept> deptlist(Dept dept, PageModel<Dept> pageModel);

    List<Province> deptProvincelist();

    List<City> deptcitylist(City city);

    Boolean deptadd(Dept dept);

    Dept finddept(Integer deptId);

    Boolean updatedept(Dept dept);

    Boolean updatedeptstatus(Integer uId);

    Dept haveornodept(String deptName);
}
