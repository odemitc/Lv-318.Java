package com.example.demo.repository;

import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.RatingCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingCriteriaRepository extends JpaRepository<RatingCriteria, Integer> {
    Optional<FeedbackCriteria> findByWeight(Integer weight);

}
