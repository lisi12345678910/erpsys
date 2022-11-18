package com.zte.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {

  private Integer jobId;
  private String jobName;
  private String jobState;
  private Integer jobDeptId;

  private String deptName;



}
