package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

//    @OneToOne
//    @JoinColumn(name = "rating_id")
//    private int rating;
}
