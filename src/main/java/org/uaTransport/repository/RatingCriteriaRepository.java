package org.uaTransport.repository;

import org.uaTransport.entity.FeedbackCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingCriteriaRepository extends JpaRepository<FeedbackCriteria, Integer> {

//    Optional<FeedbackCriteria> findByWeight(Integer weight);
//    List<RatingCriteria> findByWeightList(Integer weight); // This list format may not be necessary


}
