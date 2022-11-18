package com.zte.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

  private Integer id;
  private Integer pId;
  private String cName;
  private String cNumber;

  private String pName;



}
