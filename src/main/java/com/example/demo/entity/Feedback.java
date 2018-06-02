package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode(of ="id")
public class Feedback {

    @Id
    @GeneratedValue
    private Integer id;

    private String answer;
    private Integer userId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transit_id")
    private Transit transit;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "criteria_id")
    private FeedbackCriteria feedbackCriteria;

}
