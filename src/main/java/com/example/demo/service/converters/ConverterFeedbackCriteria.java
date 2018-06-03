package com.example.demo.service.converters;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Rate;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class ConverterFeedbackCriteria implements Converter {
    @Override
    public Rate convertAnswer(Feedback feedback) {
        return new Rate(0);
    }
}
