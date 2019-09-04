package com.qfjy.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
//添加一个序列化标识
public class Questions implements Serializable {
    private Integer id;

    private String question;

    private Short correctAnswer;

    private Integer sortnum;

    private Short stutas;

}