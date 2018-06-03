package com.example.demo.service.converters;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.RatingCriteria;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class ConverterContext {
    private static ConverterContext instance;
    private Converter converter;

    public Converter getConverter() {
        return converter;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    private ConverterContext() {

    }

    public boolean isRatingCriteria(Feedback feedback) {
        return feedback.getFeedbackCriteria().getClass().equals(RatingCriteria.class);
    }

    public static ConverterContext getInstance() {
        if (instance == null)
            instance = new ConverterContext();
        return instance;
    }

}



