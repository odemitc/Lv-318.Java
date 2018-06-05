package com.example.demo.service.converter;

import com.example.demo.entity.Feedback;

public interface ConversionStrategy<T> {
    T convert(Feedback feedback);
}
