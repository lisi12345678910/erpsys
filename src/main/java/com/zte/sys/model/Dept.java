package com.zte.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

  private Integer deptId;
  private String deptName;
  private String deptState;
  private Integer pId;
  private Integer cId;

  private String cName;



}
