package com.example.demo.entity;

import com.example.demo.service.converters.Converter;
import com.example.demo.service.converters.ConverterContext;
import com.example.demo.service.converters.ConverterFeedbackCriteria;
import com.example.demo.service.converters.ConverterRaitingCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class Rate {

    private Integer value;
    private ConverterContext context;

    public Rate(Integer value) {
        this.value = value;
        this.context = ConverterContext.getInstance();
    }

    private Double counter(List<Rate> rates) {
        return rates.stream()
                .mapToInt(Rate::getValue)
                .average()
                .orElse(0);
    }

    private List<Rate> makeListRates(List<Feedback> feedbackList) {
        return feedbackList.stream()
                .peek(feedback -> {
                    if (context.isRatingCriteria(feedback))
                        context.setConverter(new ConverterRaitingCriteria());
                    else
                        context.setConverter(new ConverterFeedbackCriteria());

                })
                .map(feedback -> context.getConverter().convertAnswer(feedback))
                .collect(toList());
    }

    public Double makeRate(List<Feedback> feedbackList) {
        return counter(makeListRates(feedbackList));
    }

}
