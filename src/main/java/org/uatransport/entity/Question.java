package org.uatransport.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@Table(name="question")
@EqualsAndHashCode(of = "id")
public class Question {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer groupId;

    private String questionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criteria_id")
    private FeedbackCriteria feedbackCriteria;

}