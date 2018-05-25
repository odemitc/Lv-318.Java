package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
    List<Feedback> findByTransitId(Integer id);
}
