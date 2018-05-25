package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Stop {
    @Id
    @GeneratedValue
    @MapKey
    private int id;
    private String street;
    private String building;
}
