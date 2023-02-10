package com.zte.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

  @TableId
  private Integer uId;
  private String uname;
  private String upassword;
  private String utelephone;
  private Integer jobId;
  private Integer sex;
  private Integer statusId = 1;
  private Date hiredate;
  private Date leavedate;
  private Date birthday;
  private Integer deptId;

  @TableField(exist = false)
  private String deptName;
  @TableField(exist = false)
  private String jobName;



}
