package org.uaTransport.service.converter;

import org.uaTransport.entity.Feedback;

public interface ConversionStrategy<T> {
    T convert(Feedback feedback);
}
