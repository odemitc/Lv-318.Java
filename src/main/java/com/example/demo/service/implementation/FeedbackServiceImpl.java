package com.example.demo.service.implementation;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;


    @Override
    @Transactional
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        feedbackRepository.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Feedback getByAnswer(String answer) {
        return feedbackRepository.getByAnswer(answer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitId(Integer id) {
        return feedbackRepository.findByTransitId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByFeedbackCriteria(Integer id) {
        return feedbackRepository.findByFeedbackCriteriaId(id);
    }

    @Override
    @Transactional
    public Feedback update(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Feedback> getById(Integer id) {
        return feedbackRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getAll() {
        return Streams.stream(feedbackRepository.findAll()).collect(Collectors.toList());
    }
}
