package com.zte.sys.dao;

import com.zte.sys.model.Dept;
import com.zte.sys.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysDeptDao {
    List<Dept> deptlist(Dept dept);

    List<Dept> simpledeptlist();
}
