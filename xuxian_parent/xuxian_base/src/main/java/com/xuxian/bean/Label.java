package com.xuxian.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_label")
public class Label {

    @Id
    private String id;
    private String labelName;
    private String state;
    private Long count;
    private Long fans;
    private String recommend;

}
