package com.example.demo.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
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

//    @CollectionTable(name = "stops_order",
//            joinColumns = @JoinColumn(name = "transit_id"))
//    @Column(name = "stop_number")
//    @ElementCollection
//    @MapKeyJoinColumn(name = "stop", referencedColumnName = "id")
//    private Map<Stop, Integer> stopOrder ;
//

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
