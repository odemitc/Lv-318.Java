package com.example.demo.entity;

import com.example.demo.service.converters.Converter;
import com.example.demo.service.converters.ConverterContext;
import com.example.demo.service.converters.ConverterFeedbackCriteria;
import com.example.demo.service.converters.ConverterRaitingCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Accessors(chain = true)
@Component
@RequiredArgsConstructor
public class Rate {

    private final Integer value;

    private void setConverter(Feedback feedback, ConverterContext context) {
        if (context.isRatingCriteria(feedback))
            context.setConverter(new ConverterRaitingCriteria());
        else
            context.setConverter(new ConverterFeedbackCriteria());
    }

    private List<Rate> makeListRates(List<Feedback> feedbackList, ConverterContext context) {
        return feedbackList.stream()
                .peek(feedback -> setConverter(feedback, context))
                .map(feedback -> context.getConverter().convertAnswer(feedback))
                .collect(toList());
    }

    private Double counter(List<Rate> rates) {
        return rates.stream()
                .mapToInt(Rate::getValue)
                .average()
                .orElse(0);
    }

    public Double makeRate(List<Feedback> feedbackList, ConverterContext context) {
        return counter(makeListRates(feedbackList, context));
    }

}
