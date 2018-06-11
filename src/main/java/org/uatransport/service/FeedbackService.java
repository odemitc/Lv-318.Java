package org.uatransport.service;

import org.uatransport.entity.Feedback;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.entity.dto.FeedbackDTO;

import java.util.List;

public interface FeedbackService {

    Feedback addFeedback(FeedbackDTO feedbackDTO);

    Feedback getById(Integer id);

    List<Feedback> getByTransitId(Integer id);

    List<Feedback> getByCriteriaId(Integer id);

    List<Feedback> getByUserId(Integer id);

    List<Feedback> getByTransitAndFeedbackCriteria(Integer transitId, FeedbackCriteria.FeedbackType feedbackType);

    Double convertRatingFeedBacks(Integer transitId);

    List<Feedback> addAll(List<FeedbackDTO> feedbackDTOList);
}
