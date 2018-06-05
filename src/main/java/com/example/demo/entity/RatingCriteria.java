package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("RATING_CRITERIA")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class RatingCriteria extends FeedbackCriteria {

    private Integer weight;
}
