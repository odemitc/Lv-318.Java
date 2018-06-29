package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;
import org.uatransport.service.converter.model.RatingFeedback;

import java.util.List;

public class RatingConversionStrategy implements ConversionStrategy<Integer> {

    @Override
    public Integer convert(Feedback feedback) {
        return Integer.parseInt(feedback.getAnswer());
    }

    @SneakyThrows
    public Double apply(Feedback feedback) {
        List<RatingFeedback> answers = new ObjectMapper().readValue(feedback.getAnswer(),
                new TypeReference<List<RatingFeedback>>() {
                });
        return answers.stream().mapToInt(answer -> answer.getAnswer() * answer.getWeight()).average().orElse(0.0);
    }
}
