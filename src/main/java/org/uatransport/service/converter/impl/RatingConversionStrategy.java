package org.uatransport.service.converter.impl;

import org.uatransport.entity.Feedback;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.service.converter.ConversionStrategy;

import java.util.function.BiFunction;

public class RatingConversionStrategy
    implements BiFunction<String, FeedbackCriteria, Integer>, ConversionStrategy<Integer> {

    @Override
    public Integer convert(Feedback feedback) {
        return Integer.parseInt(feedback.getAnswer());
    }

    @Override
    public Integer apply(String answer, FeedbackCriteria ratingCriteria) {
        return Integer.parseInt(answer) * ratingCriteria.getWeight();
    }
}
