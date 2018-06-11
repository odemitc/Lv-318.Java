package org.uatransport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.entity.RatingCriteria;

import java.util.Optional;

public interface RatingCriteriaRepository extends JpaRepository<RatingCriteria, Integer> {
    Optional<FeedbackCriteria> findByWeight(Integer weight);

}
