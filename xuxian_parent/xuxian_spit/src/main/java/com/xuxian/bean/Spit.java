package com.xuxian.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spit implements Serializable {

    @Id
    private String id;
    private String content;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;
    private String userId;
    private String nickName;
    private long visits;
    private long thumbsUp;
    private long share;
    private long comment;
    private String state;
    private String parentId;
}
