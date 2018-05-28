package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.FeedbackCriteria;
public interface FeedbackCriteriaService {

    Optional <FeedbackCriteria> getById(Integer id);

    List<FeedbackCriteria> getByGroupId(Integer groupId);

    List<FeedbackCriteria> getByQuestion(String question);

    List<FeedbackCriteria> getByType(FeedbackCriteria.FeedbackType type);
}
