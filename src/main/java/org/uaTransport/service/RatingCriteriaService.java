package org.uaTransport.service;

import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.RatingCriteria;

import java.util.List;

public interface RatingCriteriaService {

    RatingCriteria save(RatingCriteria ratingCriteria);

    void delete(Integer weight);

    void delete(RatingCriteria ratingCriteria);

    RatingCriteria update(RatingCriteria ratingCriteria);

    List<FeedbackCriteria> getAll();
//    FeedbackCriteria getByWeight(Integer weight);
//    List<RatingCriteria> getByWeightList(Integer weight); // is this needed?

}
