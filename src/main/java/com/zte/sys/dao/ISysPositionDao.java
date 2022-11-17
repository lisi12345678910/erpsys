package com.zte.sys.dao;

import com.zte.sys.model.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysPositionDao {

    List<Job> positionlist(Job job);
}
