package com.example.demo.service.implementation;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.repository.FeedbackCriteriaRepository;
import com.example.demo.service.FeedbackCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedbackCriteriaImpl  implements FeedbackCriteriaService {

    private final FeedbackCriteriaRepository feedbackCriteriaRepository;

    @Override
    public Optional<FeedbackCriteria> getById(Integer id) {
        return feedbackCriteriaRepository.findById(id);
    }

    @Override
    public List<FeedbackCriteria> getByGroupId(Integer groupId) {
        return feedbackCriteriaRepository.findByGroupId(groupId);
    }

    @Override
    public List<FeedbackCriteria> getByQuestion(String question) {
        return feedbackCriteriaRepository.findByQuestion(question);
    }

    @Override
    public List<FeedbackCriteria> getByType(FeedbackCriteria.FeedbackType type) {
        return feedbackCriteriaRepository.findByType(type);
    }

    public void delete(FeedbackCriteria feedbackCriteria){
        feedbackCriteriaRepository.delete(feedbackCriteria);
    }

    public FeedbackCriteria save(FeedbackCriteria feedbackCriteria){
        return feedbackCriteriaRepository.save(feedbackCriteria);
    }

    public FeedbackCriteria update(FeedbackCriteria feedbackCriteria){
        return feedbackCriteriaRepository.save(feedbackCriteria);
    }
}
