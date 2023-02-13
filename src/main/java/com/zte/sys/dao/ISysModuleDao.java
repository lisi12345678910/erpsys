package com.zte.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zte.login.model.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISysModuleDao extends BaseMapper<Module> {

    List<Module> modulelist(Module module);

    List<Module> simplefathermodulelist();

    Boolean moduleadd(Module module);

    Module findmodule(@Param("moduleId") Integer moduleId);

    Boolean updatemodule(Module module);

    List<Module> simplemodulelist();


    List<Module> sonmodule(Integer moduleId);

    Boolean updatemodulestatus(@Param("uId") Integer uId);

    List<Integer> sonmoudlelist(Integer uId);

    Module isfather(Integer mId);

    void updatesonmodulestatus(@Param("integer")Integer integer);

    Module haveornomodule(String moduleRname);
}
