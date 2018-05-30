package com.example.demo.service;

import com.example.demo.entity.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    void delete(Integer id);

    Feedback update(Feedback feedback);

    Feedback getByAnswer(String name);

    List<Feedback> getByTransitId(Integer id);

    List<Feedback> getByFeedbackCriteria(Integer id);

    List<Feedback> getByUserId(Integer id);

    List<Feedback> getAll();

    Optional<Feedback> getById(Integer id);
}
