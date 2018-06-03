package com.example.demo.service.implementation;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import com.google.common.base.Strings;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            feedbackRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Transit with id '%s' not found", id));
        }
    }

    @Override
    @Transactional
    public Feedback update(Feedback feedback) {
        return feedbackRepository.findById(feedback.getId())
                .map(feedback1 -> feedbackRepository.save(feedback))
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Feedback with id '%s' not found", feedback.getId())));
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
    public List<Feedback> getAll() {
        return Streams.stream(feedbackRepository.findAll()).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Feedback getByAnswer(String answer) {
        if (Strings.isNullOrEmpty(answer)) {
            throw new IllegalArgumentException("Answer should not be empty");
        }
        return feedbackRepository.getByAnswer(answer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findByTransitId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByFeedbackCriteria(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findByFeedbackCriteriaId(id);
    }

    @Override
    public List<Feedback> getByUserId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.findByUserId(id);
    }


}