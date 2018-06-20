package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;
import org.uatransport.service.converter.model.CapacityHourFeedback;

@RequiredArgsConstructor
public class FeedbackTypeConverter<T> implements ConversionStrategy {
    private final Class<T> type;

    @Override
    @SneakyThrows
    public T convert(Feedback feedback) {
        return new ObjectMapper().readValue(feedback.getAnswer(), this.type);
    }
}
