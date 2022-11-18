package com.zte.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province implements Serializable {

  private Integer id;
  private String pName;
  private String pNumber;

}
