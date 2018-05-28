package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.*;
import java.util.Objects;
import com.example.demo.entity.Stop;
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

    @CollectionTable(name = "stops_order",
            joinColumns = @JoinColumn(name = "transit_id"))
    @Column(name = "stop_number")
    @ElementCollection
    @MapKeyJoinColumn(name = "stop", referencedColumnName = "id")
    private Map<Stop, Integer> stopOrder ;

}
