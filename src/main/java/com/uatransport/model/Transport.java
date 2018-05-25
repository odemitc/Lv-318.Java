package com.uatransport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany
    private Set<Vehicle> vehicles = new HashSet<>();

    public Transport() {}

    public Transport(String name) {
        this.name = name;
    }

}
