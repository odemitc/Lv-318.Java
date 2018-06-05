package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.Transit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByTransitId(Integer id);

    List<Feedback> findByUserId(Integer id);

    List<Feedback> findByFeedbackCriteriaId(Integer id);

    List<Feedback> findByTransitAndFeedbackCriteriaType(Transit transit, FeedbackCriteria.FeedbackType feedbackType);

}
