package org.uaTransport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uaTransport.entity.FeedbackCriteria;

import java.util.Optional;

public interface RatingCriteriaRepository extends JpaRepository<RatingCriteria, Integer> {
    Optional<FeedbackCriteria> findByWeight(Integer weight);

}
