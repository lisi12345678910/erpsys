package com.zte.sys.dao;

import com.zte.sys.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysModuleDao {

    List<Module> modulelist(Module module);
}
