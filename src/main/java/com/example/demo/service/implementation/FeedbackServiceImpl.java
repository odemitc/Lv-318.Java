package com.example.demo.service.implementation;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.converter.impl.BusyHoursDurationConversionStrategy;
import com.google.common.base.Strings;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public Feedback addFeedback(Feedback feedback) {
        if (feedback == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.save(feedback);
    }


    @Override
    @Transactional(readOnly = true)
    public Feedback getById(Integer id) throws MethodArgumentTypeMismatchException {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Feedback with id '%s' not found", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findByTransit_Id(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByCriteriaId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findByFeedbackCriteria_Id(id);
    }

    @Override
    public List<Feedback> getByUserId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findByUserId(id);
    }
//
//    @PostConstruct
//    private void init() {
//        List<Duration> busyHours = getByTransitId(1).stream()
//                .filter(feedback -> feedback.getFeedbackCriteria().getType() == FeedbackCriteria.FeedbackType.BUSY_HOURS)
//                .<List<Duration>>map(FeedbackCriteria.FeedbackType.BUSY_HOURS::convertFeedback)
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        double rating = getByTransitId(1).stream()
//                .filter(feedback -> feedback.getFeedbackCriteria().getType() == FeedbackCriteria.FeedbackType.RATING)
//                .mapToInt(FeedbackCriteria.FeedbackType.RATING::convertFeedback)
//                .average()
//                .orElseThrow(() -> new ResourceNotFoundException("No feedbacks found for transit with id 18"));
//    }
}