package com.example.demo.repository;

import com.example.demo.entity.FeedbackCriteria;

import java.util.List;
import java.util.Optional;

public interface RatingCriteriaRepository {

    Optional<FeedbackCriteria> findByWeight(Integer weight);
    List<FeedbackCriteria> findByWeightList(Integer weight); // This list format may not be necessary

}
