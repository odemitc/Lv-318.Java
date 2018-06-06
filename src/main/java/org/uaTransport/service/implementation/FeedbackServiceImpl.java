package org.uaTransport.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;
import org.uaTransport.exception.ResourceNotFoundException;
import org.uaTransport.repository.FeedbackRepository;
import org.uaTransport.service.FeedbackService;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Override
    public Feedback addFeedback(Feedback feedback) {
        if (feedback == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.save(feedback);
    }


    @Override
    @Transactional(readOnly = true)
    public Feedback getById(Integer id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Feedback with id '%s' not found", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitId(Integer id) {
        return feedbackRepository.findByTransitId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByCriteriaId(Integer id) {
        return feedbackRepository.findByFeedbackCriteriaId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByUserId(Integer id) {
        return feedbackRepository.findByUserId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitAndFeedbackCriteria(Transit transit, FeedbackCriteria.FeedbackType feedbackType) {
        return feedbackRepository.findByTransitAndFeedbackCriteriaType(transit, feedbackType);
    }


    public List<Duration> convertBusyHoursFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(new Transit().setId(transitId), FeedbackCriteria.FeedbackType.BUSY_HOURS)
                .stream()
                .<List<Duration>>map(FeedbackCriteria.FeedbackType.BUSY_HOURS::convertFeedback)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    public Double convertRatingFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(new Transit().setId(transitId), FeedbackCriteria.FeedbackType.RATING)
                .stream()
                .mapToInt(FeedbackCriteria.FeedbackType.RATING::convertFeedback)
                .average()
                .orElseThrow(ResourceNotFoundException::new);
    }

}