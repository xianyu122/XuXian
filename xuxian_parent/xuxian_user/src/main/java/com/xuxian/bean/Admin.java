package com.xuxian.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_admin")
public class Admin implements Serializable {

  @Id
  private String id;
  private String loginName;
  private String password;
  private String state;

}
