package com.zte.sys.service;

import com.zte.common.model.City;

import com.zte.util.PageModel;

public interface ISysCityService {

    PageModel<City> arealist(City city, PageModel<City> pageModel);
}
