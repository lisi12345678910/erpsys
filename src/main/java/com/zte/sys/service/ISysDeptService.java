package com.zte.sys.service;

import com.zte.sys.model.City;
import com.zte.sys.model.Dept;
import com.zte.sys.model.Province;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysDeptService {
    PageModel<Dept> deptlist(Dept dept, PageModel<Dept> pageModel);

    List<Province> deptProvincelist();

    List<City> deptcitylist(City city);
}
