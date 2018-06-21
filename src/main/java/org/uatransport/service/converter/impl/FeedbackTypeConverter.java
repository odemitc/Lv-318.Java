package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;

@RequiredArgsConstructor
public class FeedbackTypeConverter<T> implements ConversionStrategy {
    private final Class<T> type;

    @Override
    @SneakyThrows
    public T convert(Feedback feedback) {
        return new ObjectMapper().readValue(feedback.getAnswer(), this.type);
    }
}
