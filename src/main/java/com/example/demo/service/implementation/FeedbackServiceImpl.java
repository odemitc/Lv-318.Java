package com.example.demo.service.implementation;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.saveAndFlush(feedback);
    }


    @Override
    public void delete(int id) {
        feedbackRepository.deleteById(id);

    }

    @Override
    public Feedback getByAnswer(String answer) {
        return feedbackRepository.getByAnswer(answer);
    }

    @Override
    public List<Feedback> getByTransitId(int id) {
        return feedbackRepository.findByTransitId(id);
    }

    @Override
    public List<Feedback> getByFeedbackCriteria(int id) {
        return feedbackRepository.findByFeedbackCriteriaId(id);
    }

    @Override
    public Feedback update(Feedback feedback) {
        return feedbackRepository.saveAndFlush(feedback);
    }

    @Override
    public Optional<Feedback> findById(int id){
        return feedbackRepository.findById(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }
}
