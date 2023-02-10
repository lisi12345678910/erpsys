package com.zte.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zte.login.model.Module;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysModuleService extends IService<Module> {

    PageModel<Module> modulelist(Module module, PageModel<Module> pageModel);

    List<Module> simplefathermodulelist();

    Boolean moduleadd(Module module);

    Module findmodule(Integer moduleId);

    Boolean updatemodule(Module module);

    Boolean updatemodulestatus(Integer uId);

    Module haveornomodule(String moduleRname);
}
