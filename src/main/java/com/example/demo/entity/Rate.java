package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
@RequiredArgsConstructor
public class Rate {

    @Id
    @GeneratedValue
    private Integer id;

    private final Integer value;

}
