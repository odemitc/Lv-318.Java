package com.example.demo.service.converter;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Rate;

public interface ConversionStrategy<T> {
    T convert(Feedback feedback);
}
