package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;
import org.uatransport.service.model.CapacityFeedback;

public class CapacityBusyHoursConversionStrategy implements ConversionStrategy<CapacityFeedback> {


    @Override
    @SneakyThrows
    public CapacityFeedback convert(Feedback feedback) {
        return new ObjectMapper().readValue(feedback.getAnswer(), CapacityFeedback.class);
    }

}
