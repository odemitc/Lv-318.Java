package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;

import java.time.Duration;
import java.util.List;

public class BusyHoursDurationConversionStrategy implements ConversionStrategy<List<Duration>>, Function<Feedback, List<Duration>> {

    @Override
    @SneakyThrows
    public List<Duration> convert(Feedback feedback) {
        String answer = feedback.getAnswer();
        return new ObjectMapper().readValue(answer, new TypeReference<List<Duration>>() {
        });
    }

    @Override
    public List<Duration> apply(Feedback feedback) {
        return convert(feedback);
    }
}
