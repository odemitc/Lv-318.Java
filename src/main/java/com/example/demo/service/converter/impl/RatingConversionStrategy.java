package com.example.demo.service.converter.impl;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.RatingCriteria;
import com.example.demo.service.converter.ConversionStrategy;

import java.util.function.BiFunction;
import java.util.function.Function;

public class RatingConversionStrategy implements BiFunction<String, RatingCriteria, Integer>, ConversionStrategy<Integer> {

    @Override
    public Integer convert(Feedback feedback) {
        return Integer.parseInt(feedback.getAnswer()) * ((RatingCriteria) feedback.getFeedbackCriteria()).getWeight();
    }

    @Override
    public Integer apply(String answer, RatingCriteria ratingCriteria) {
        return Integer.parseInt(answer) * ratingCriteria.getWeight();
    }
}
