package com.example.demo.service;

import com.example.demo.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    Feedback getById(Integer id);

    List<Feedback> getByTransitId(Integer id);

    List<Feedback> getByCriteriaId(Integer id);

    List<Feedback> getByUserId(Integer id);

}
