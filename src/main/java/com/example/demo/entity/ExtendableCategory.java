package com.example.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@Inheritance
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("EXTENDABLE")
@Accessors(chain = true)
@Table(name = "category")
public class ExtendableCategory {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "next_level_category_id")
    private ExtendableCategory nextLevelCategory;
}
