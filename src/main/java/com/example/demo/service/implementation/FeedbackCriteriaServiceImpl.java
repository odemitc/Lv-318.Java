package com.example.demo.service.implementation;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.repository.FeedbackCriteriaRepository;
import com.example.demo.service.FeedbackCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedbackCriteriaServiceImpl implements FeedbackCriteriaService {

    private final FeedbackCriteriaRepository feedbackCriteriaRepository;

    @Transactional
    public FeedbackCriteria save(FeedbackCriteria feedbackCriteria){
        if (feedbackCriteria == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackCriteriaRepository.save(feedbackCriteria);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        feedbackCriteriaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(FeedbackCriteria feedbackCriteria){
        if(feedbackCriteria == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        feedbackCriteriaRepository.delete(feedbackCriteria);
    }

    @Transactional
    public FeedbackCriteria update(FeedbackCriteria feedbackCriteria){
        if(feedbackCriteria == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackCriteriaRepository.saveAndFlush(feedbackCriteria);
    }
    @Override
    public List<FeedbackCriteria> getAll() {
        return feedbackCriteriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FeedbackCriteria> getById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackCriteriaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FeedbackCriteria> getByGroupId(Integer groupId) {
        if(groupId == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackCriteriaRepository.findByGroupId(groupId);
    }

    @Override
    public List<FeedbackCriteria> getByQuestion(String question) {
        if(question == null){
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackCriteriaRepository.findByQuestion(question);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FeedbackCriteria> getByType(FeedbackCriteria.FeedbackType type) {
        return feedbackCriteriaRepository.findByType(type);
    }
}
