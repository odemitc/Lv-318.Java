package org.uatransport.service.converter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.uatransport.entity.Feedback;
import org.uatransport.service.converter.ConversionStrategy;
import org.uatransport.service.model.AccepterFeedback;
import org.uatransport.service.model.CapacityBusyHoursFeedback;

public class AccepterConversionStrategy implements ConversionStrategy<AccepterFeedback> {

    @Override
    @SneakyThrows
    public AccepterFeedback convert(Feedback feedback) {
        return new ObjectMapper().readValue(feedback.getAnswer(), AccepterFeedback.class);
    }

}