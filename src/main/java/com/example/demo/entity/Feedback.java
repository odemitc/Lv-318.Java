package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue
    private int id;

    private String answer;
    private int userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transit_id")
    private Transit transit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "criteria_id")
    private FeedbackCriteria feedbackCriteria;
}
