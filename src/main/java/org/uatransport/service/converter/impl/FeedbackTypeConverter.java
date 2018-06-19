package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;

@Data
public class FeedbackTypeConverter<T> implements ConversionStrategy {
    private T type;

    @Override
    @SneakyThrows
    public T convert(Feedback feedback) {
        return new ObjectMapper().readValue(feedback.getAnswer(), (TypeReference) type);
    }
}
