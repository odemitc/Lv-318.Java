package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findByTransitId(Integer id);

    List<Feedback> findByFeedbackCriteriaId(Integer id);

    Feedback getByAnswer(String answer);
}
