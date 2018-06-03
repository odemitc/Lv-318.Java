package com.example.demo.service.implementation;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Rate;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.RateRepository;
import com.example.demo.service.RateService;
import com.example.demo.service.converters.ConverterContext;
import com.example.demo.service.converters.ConverterFeedbackCriteria;
import com.example.demo.service.converters.ConverterRatingCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;

    private void setConverter(Feedback feedback, ConverterContext context) {
        if (context.isRatingCriteria(feedback))
            context.setConverter(new ConverterRatingCriteria());
        else
            context.setConverter(new ConverterFeedbackCriteria());
    }

    private List<Rate> makeListRates(List<Feedback> feedbackList, ConverterContext context) {
        return feedbackList.stream()
                .peek(feedback -> setConverter(feedback, context))
                .map(feedback -> context.getConverter().convertAnswer(feedback))
                .collect(toList());
    }

    private Double counter(List<Rate> rates) {
        return rates.stream()
                .mapToInt(Rate::getValue)
                .average()
                .orElse(0);
    }

    public Double makeRate(List<Feedback> feedbackList, ConverterContext context) {
        return counter(makeListRates(feedbackList, context));
    }

    @Override
    public Rate addRate(Rate rate) {
        if (rate == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return rateRepository.save(rate);
    }

    @Override
    public Rate update(Rate rate) {
        return rateRepository.findById(rate.getId())
                .map(feedback1 -> rateRepository.save(rate))
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Rate with id '%s' not found", rate.getId())));
    }


    @Override
    public Rate getById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return rateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Rate with id '%s' not found", id)));
    }
}
