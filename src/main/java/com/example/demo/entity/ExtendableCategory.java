package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Inheritance
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("EXTENDABLE")
@Accessors(chain = true)
@Table(name = "category")
@EqualsAndHashCode(of = "id")
public class ExtendableCategory {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToOne()
    @JoinColumn(name = "next_level_category_id", foreignKey = @ForeignKey())
    private ExtendableCategory nextLevelCategory;
}
