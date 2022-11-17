package com.zte.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zte.sys.model.Dept;
import com.zte.sys.model.Users;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysUserService extends IService<Users>{

    PageModel<Users> userlist(Users users, PageModel<Users> pageModel);


    List<Dept> simpledeptlist();
}
