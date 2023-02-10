package com.zte.sys.dao;

import com.zte.common.model.Job;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISysPositionDao {

    List<Job> positionlist(Job job);

    List<Job> simplejobslist(Job job);

    Boolean positionadd(Job job);

    Job findjob(@Param("jobId") Integer jobId);

    Boolean updateposition(Job job);


    List<Integer> getCompidList(Integer jobId);

    Boolean updategrant1(@Param("jobid") String jobid);

    Boolean updategrant2(@Param("jobid") String jobid, @Param("grant") String grant);

    Boolean updatepositionstatus(@Param("uId") Integer uId);

    List<Job> queryjobs(Integer deptId);


    Job haveornoposition(String jobName);
}
