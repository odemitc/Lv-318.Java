package com.example.demo.repository;

import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.RatingCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingCriteriaRepository extends JpaRepository<FeedbackCriteria, Integer> {

    Optional<FeedbackCriteria> findByWeight(Integer weight);
    List<RatingCriteria> findByWeightList(Integer weight); // This list format may not be necessary

}
