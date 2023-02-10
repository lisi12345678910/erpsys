package com.zte.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zte.common.model.Job;
import com.zte.sys.model.Dept;

import com.zte.sys.model.Users;
import com.zte.util.PageModel;

import java.util.List;

public interface ISysUserService extends IService<Users>{

    PageModel<Users> userlist(Users users, PageModel<Users> pageModel);


    List<Dept> simpledeptlist();

    List<Job> simplejobslist(Job job);


    Boolean usersadd(Users users);

    Boolean updatestatus(Integer uId);

    Users finduser(Integer uId);

    Boolean updateuser(Users users);

    List<Job> queryjobs(Integer deptId);
}
