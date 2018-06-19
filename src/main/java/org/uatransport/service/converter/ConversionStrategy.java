package org.uatransport.service.converter;

import org.uatransport.entity.Feedback;

public interface ConversionStrategy<T> {
    T convert(Feedback feedback);
}
