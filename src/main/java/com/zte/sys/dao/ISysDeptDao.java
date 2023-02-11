package com.zte.sys.dao;

import com.zte.common.model.Job;
import com.zte.sys.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISysDeptDao {
    Boolean deptadd(Dept dept);


    List<Dept> deptlist(Dept dept);

    List<Dept> simpledeptlist();

    Dept finddept(@Param("deptId") Integer deptId);

    Boolean updatedept(Dept dept);

    Boolean updatedeptstatus(@Param("uId") Integer uId);

    Dept haveornodept(String deptName);

    Job getJob(Integer integer);
}
