package org.uatransport.service.converter.impl;

import java.util.function.BiFunction;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.service.converter.ConversionStrategy;

public class RatingConversionStrategy
    implements BiFunction<String, FeedbackCriteria, Integer>, ConversionStrategy<Integer> {

  @Override
  public Integer convert(Feedback feedback) {
    return Integer.parseInt(feedback.getAnswer());
    // *
    // (
    // feedback.getFeedbackCriteria()).getWeight();
  }

  @Override
  public Integer apply(String answer, FeedbackCriteria ratingCriteria) {
    return Integer.parseInt(answer) * ratingCriteria.getWeight();
  }
}
