package com.xuxian.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean flag;  // 是否成功
    private Integer code;  // 返回编码
    private String msg;  // 返回消息
    private Object data;  // 返回数据

}
