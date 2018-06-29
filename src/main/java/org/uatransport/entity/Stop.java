package org.uatransport.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String street;

    private Double lat;

    private Double lng;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "dir", updatable = false)
    private Stop.DIRECTION direction;

    @RequiredArgsConstructor
    public enum DIRECTION {
        FORWARD, BACKWARD
    }

}
