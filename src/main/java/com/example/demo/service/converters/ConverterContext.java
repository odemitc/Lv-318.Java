package com.example.demo.service.converters;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.RatingCriteria;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@Component
public class ConverterContext {
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


}



