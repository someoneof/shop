package com.demo.domain.supportBean;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Entity
@Data
@ToString
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;

    private String name;

    public Student(String name) {
        this.name = name;
    }
}
