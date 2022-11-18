package com.zte.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Journal implements Serializable {

  private Integer jId;
  private Integer moduleId;
  private Integer uId;
  private String jcontent;
  private Date jdate;

  private String moduleRname;
  private String uname;

  private Date upjdate;
  private Date downjdate;

}
