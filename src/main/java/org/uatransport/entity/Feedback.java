package org.uatransport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Feedback {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  private String answer;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "user_id")
  private User user;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "transit_id")
  private Transit transit;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "criteria_id")
  private FeedbackCriteria feedbackCriteria;
}
