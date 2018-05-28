package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.FeedbackCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackCriteriaRepository  extends JpaRepository<FeedbackCriteria, Integer>{

    Optional<FeedbackCriteria> findById(Integer id);

    List<FeedbackCriteria> findByGroupId(Integer groupId);

    List<FeedbackCriteria> findByQuestion(String question);

    List<FeedbackCriteria> findByType(FeedbackCriteria.FeedbackType type);
}
