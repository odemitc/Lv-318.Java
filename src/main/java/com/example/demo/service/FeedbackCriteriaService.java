package com.example.demo.service;

import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.RatingCriteria;

import java.util.List;
import java.util.Optional;


public interface FeedbackCriteriaService {
    FeedbackCriteria save(FeedbackCriteria feedbackCriteria);

    void delete(Integer id);

    void delete(FeedbackCriteria feedbackCriteria);

    FeedbackCriteria update(FeedbackCriteria feedbackCriteria);
    List<FeedbackCriteria> getAll();

    FeedbackCriteria getById(Integer id);

    List<FeedbackCriteria> getByGroupId(Integer groupId);

    List<FeedbackCriteria> getByQuestion(String question);

    List<FeedbackCriteria> getByType(FeedbackCriteria.FeedbackType type);

    List<RatingCriteria> getByWeight(Integer id);

    List<FeedbackCriteria> getByCategoryId(Integer id);
}
