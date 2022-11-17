package com.zte.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zte.sys.model.City;
import com.zte.sys.model.Province;
import com.zte.sys.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysCityDao {

    List<City> arealist(City city);

    List<Province> deptProvincelist();

    List<City> deptcitylist(City city);
}
