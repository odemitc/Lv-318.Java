package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Stop {
    @Id
    @GeneratedValue
    private int id;
//    private int order;
    private String street;
    private String building;

}
