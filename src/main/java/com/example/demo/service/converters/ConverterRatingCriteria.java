package com.example.demo.service.converters;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Rate;
import com.example.demo.entity.RatingCriteria;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class ConverterRatingCriteria implements Converter {

    @Override
    public Rate convertAnswer(Feedback feedback) {
        RatingCriteria ratingCriteria = (RatingCriteria) feedback.getFeedbackCriteria();
        int weight = ratingCriteria.getWeight();
        return new Rate(Integer.parseInt(feedback.getAnswer()) * weight);
    }

}
