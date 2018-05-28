package com.example.demo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
public class Transit {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "transit")
    private List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private NonExtendableCategory category;

    @ManyToMany
    @JoinTable(name = "transit_stop",
        joinColumns = {
            @JoinColumn(name = "transit_id")},
        inverseJoinColumns = {
            @JoinColumn(name = "stop_id")
        }
    )
    @OrderColumn(name = "stop_index")
    private List<Stop> stops;
}
