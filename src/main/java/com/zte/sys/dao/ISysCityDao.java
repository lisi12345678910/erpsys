package com.zte.sys.dao;

import com.zte.common.model.City;
import com.zte.common.model.Province;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysCityDao {

    List<City> arealist(City city);

    List<Province> deptProvincelist();

    List<City> deptcitylist(City city);
}
