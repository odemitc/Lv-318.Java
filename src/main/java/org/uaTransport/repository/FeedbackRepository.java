package org.uaTransport.repository;

import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByTransitId(Integer id);

    List<Feedback> findByUserId(Integer id);

    List<Feedback> findByFeedbackCriteriaId(Integer id);

    List<Feedback> findByTransitAndFeedbackCriteriaType(Transit transit, FeedbackCriteria.FeedbackType feedbackType);

}
