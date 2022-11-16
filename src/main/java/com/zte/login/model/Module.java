package com.zte.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Module {

  private Integer moduleId;
  private String moduleRname;
  private Integer modulePid;
  private String moduleMurl;
  private String moduleState;

}
