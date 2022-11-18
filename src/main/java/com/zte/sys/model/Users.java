package com.zte.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

  private Integer uId;
  private String uname;
  private String upassword;
  private String utelephone;
  private Integer jobId;
  private Integer sex;
  private Integer statusId;
  private Date hiredate;
  private Date leavedate;
  private Date birthday;
  private Integer deptId;

  private String deptName;
  private String jobName;



}
