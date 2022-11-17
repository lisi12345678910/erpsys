package com.zte.sys.service;

import com.zte.sys.model.City;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysCityService {

    PageModel<City> arealist(City city, PageModel<City> pageModel);
}
