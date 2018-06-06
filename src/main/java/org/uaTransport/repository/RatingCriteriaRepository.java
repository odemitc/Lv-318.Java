package org.uaTransport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uaTransport.entity.FeedbackCriteria;

public interface RatingCriteriaRepository extends JpaRepository<FeedbackCriteria, Integer> {

//    Optional<FeedbackCriteria> findByWeight(Integer weight);
//    List<RatingCriteria> findByWeightList(Integer weight); // This list format may not be necessary


}
