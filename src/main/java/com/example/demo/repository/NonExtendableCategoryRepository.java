package com.example.demo.repository;

import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.NonExtendableCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NonExtendableCategoryRepository extends CrudRepository<NonExtendableCategory, Integer> {
    List<FeedbackCriteria> getByGroupId(Integer groupId);

    List<FeedbackCriteria> getByQuestion(String question);

    List<FeedbackCriteria> getByType(FeedbackCriteria.FeedbackType type);
}
