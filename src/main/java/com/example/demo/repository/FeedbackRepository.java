package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByTransitId(Integer id);

    List<Feedback> findByFeedbackCriteriaId(Integer id);

    Feedback getByAnswer(String answer);

}
