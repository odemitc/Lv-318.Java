package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data //TODO equals and hashCode
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
public class Stop {

    @Id
    @GeneratedValue
    private Integer id;
    private String street;
    private String building;
}
