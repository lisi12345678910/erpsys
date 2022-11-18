package com.zte.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.sys.dao.ISysModuleDao;
import com.zte.sys.model.Job;
import com.zte.login.model.Module ;
import com.zte.sys.model.Users;
import com.zte.sys.dao.ISysUserDao;

import com.zte.sys.service.ISysModuleService;
import com.zte.sys.service.ISysUserService;
import com.zte.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysModuleService implements ISysModuleService {
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

}
