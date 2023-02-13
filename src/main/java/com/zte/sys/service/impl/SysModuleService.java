package com.zte.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.login.model.Module;
import com.zte.sys.dao.ISysModuleDao;
import com.zte.sys.service.ISysModuleService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysModuleService extends ServiceImpl<ISysModuleDao, Module> implements ISysModuleService {
    @Autowired
    private ISysModuleDao iSysModuleDao;

    @Override
    public PageModel<Module> modulelist(Module module, PageModel<Module> pageModel) {
        //--------------------------------------
        int pageNum = pageModel.getPageNum();
        pageNum = pageNum <= 0 ? 1 : pageNum;

        int pageSize = pageModel.getPageSize();
        pageSize = pageSize <= 0 ? 3 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //---------------------------------------
        List<Module> moduleList = iSysModuleDao.modulelist(module);
        PageInfo<Module> usersPageInfo = new PageInfo<>(moduleList);
        //----------------------------------------
        pageModel.setPageSize(usersPageInfo.getPageSize());
        pageModel.setTotalPage(usersPageInfo.getPages());
        pageModel.setTotalCount((int) usersPageInfo.getTotal());
        pageModel.setPageNum(usersPageInfo.getPageNum());
        pageModel.setData(usersPageInfo.getList());
        //---------------------------------------

        return pageModel;
    }

    @Override
    public List<Module> simplefathermodulelist() {
        List<Module> moduleList = iSysModuleDao.simplefathermodulelist();
        return moduleList;
    }

    @Override
    public Boolean moduleadd(Module module) {
        Boolean b = iSysModuleDao.moduleadd(module);
        return b;
    }

    @Override
    public Module findmodule(Integer moduleId) {
        Module module = iSysModuleDao.findmodule(moduleId);
        return module;
    }

    @Override
    public Boolean updatemodule(Module module) {
        Boolean b = iSysModuleDao.updatemodule(module);
        return b;
    }

    @Override
    public Boolean updatemodulestatus(Integer mId) {


        Module module = iSysModuleDao.isfather(mId);

        iSysModuleDao.updatesonmodulestatus(mId);
        if (module.getModulePid()==0) {
            //是父模块
            iSysModuleDao.updatemodulestatus(mId);
        }
        return true;
    }

    @Override
    public Module haveornomodule(String moduleRname) {
        Module module = iSysModuleDao.haveornomodule(moduleRname);
        return module;
    }

}
