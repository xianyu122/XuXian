package com.xuxian.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
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
@Entity(name = "tb_article")
public class Article implements Serializable {

  @Id
  private String id;
  private String columnId;
  private String userId;
  private String title;
  private String content;
  private String image;
  @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date createTime;
  @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date updateTime;
  private String isPublic;
  private String isTop;
  private long visits;
  private long thumbsUp;
  private long comment;
  private String state;
  private String channelId;
  private String url;
  private String type;


}
