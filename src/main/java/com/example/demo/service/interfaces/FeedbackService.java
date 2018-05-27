package com.example.demo.service.interfaces;

import com.example.demo.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    void delete(int id);

    Feedback update(Feedback feedback);

    Feedback getByAnswer(String name);

    List<Feedback> getByTransitId(int id);

    List<Feedback> getByFeedbackCriteria(int id);

    List<Feedback> getAll();
}
