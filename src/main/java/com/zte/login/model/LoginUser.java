package com.zte.login.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser {

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
  private List<Module> modules;

}
