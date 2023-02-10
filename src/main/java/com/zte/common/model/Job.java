package com.zte.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {

  private Integer jobId;
  private String jobName;
  private String jobState="1";
  private Integer jobDeptId;

  private String deptName;

  private List<Integer> compidList;//权限列表



}
