package com.zte.login.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Module implements Serializable {

//  private Integer moduleId;
//  private String moduleRname;
//  private Integer modulePid;
//  private String moduleMurl;
//  private String moduleState;
//
//  private String pN;




  @TableId
  private Integer moduleId;
  private String moduleRname;
  private Integer modulePid;
  private String moduleMurl;
  private String moduleState="0";

  @TableField(exist = false)
  private String pN;

  private List<Module> sonlist;

  private Boolean isper=false;//判断是否有该权限
}
