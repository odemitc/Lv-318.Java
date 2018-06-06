package org.uaTransport.repository;

import org.springframework.data.repository.CrudRepository;
import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByTransitId(Integer id);

    List<Feedback> findByUserId(Integer id);

    List<Feedback> findByFeedbackCriteriaId(Integer id);

    List<Feedback> findByTransitIdAndFeedbackCriteriaType(Integer transitId, FeedbackCriteria.FeedbackType feedbackType);
}
