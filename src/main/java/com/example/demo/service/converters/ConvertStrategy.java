package com.example.demo.service.converters;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Rate;
import com.example.demo.entity.RatingCriteria;

public interface ConvertStrategy {

    Rate convertStrategy(Feedback feedback);

    static ConvertStrategy convertLoadCriteria() {
        return feedback -> {
            switch (feedback.getFeedbackCriteria().getLoad()) {
                case СИДІВ:
                    return new Rate(5);
                case СТОЯВ:
                    return new Rate(3);
                case ЛЕДВЕ_ЗАЛІЗ:
                    return new Rate(1);
                default:
                    return new Rate(0);
            }
        };
    }


    static ConvertStrategy convertTechnicalConditionCriteria() {
        return feedback -> new Rate(Integer.parseInt(feedback.getAnswer()));
    }

}
