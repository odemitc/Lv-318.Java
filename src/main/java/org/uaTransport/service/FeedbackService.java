package org.uaTransport.service;

import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;

import java.util.List;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    Feedback getById(Integer id);

    List<Feedback> getByTransitId(Integer id);

    List<Feedback> getByCriteriaId(Integer id);

    List<Feedback> getByUserId(Integer id);

    List<Feedback> getByTransitAndFeedbackCriteria(Integer transitId, FeedbackCriteria.FeedbackType feedbackType);

    Double convertRatingFeedBacks(Integer transitId);
}
