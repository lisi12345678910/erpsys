package com.zte.sys.service;

import com.zte.login.model.Module ;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysModuleService {

    PageModel<Module> modulelist(Module module, PageModel<Module> pageModel);
}
