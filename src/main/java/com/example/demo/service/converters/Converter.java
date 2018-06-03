package com.example.demo.service.converters;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Rate;

public interface Converter {
     Rate convertAnswer(Feedback feedback);

}
