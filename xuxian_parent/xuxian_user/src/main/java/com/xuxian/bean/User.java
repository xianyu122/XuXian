package com.xuxian.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User implements Serializable {

  @Id
  private String id;
  private String mobile;
  private String password;
  private String nickName;
  private String sex;
  private Date birthday;
  private String headUrl;
  private String email;
  private Date registerDate;
  private Date updateDate;
  private Date lastDate;
  private long online;
  private String interest;
  private String personality;
  private long fansCount;
  private long followCount;

}
