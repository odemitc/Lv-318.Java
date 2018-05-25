package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Transit {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "transit")
    private List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private NonExtendableCategory category;
}
