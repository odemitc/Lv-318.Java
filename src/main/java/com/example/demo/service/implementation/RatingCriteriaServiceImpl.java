package com.example.demo.service.implementation;

import com.example.demo.entity.RatingCriteria;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RatingCriteriaRepository;
import com.example.demo.service.RatingCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingCriteriaServiceImpl implements RatingCriteriaService {

    private final RatingCriteriaRepository ratingCriteriaRepository;

//    public RatingCriteriaServiceImpl(RatingCriteriaRepository ratingCriteriaRepository) {
//        this.ratingCriteriaRepository = ratingCriteriaRepository;
//    }

    @Override
    public RatingCriteria save(RatingCriteria ratingCriteria) {
        if (ratingCriteria == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return ratingCriteriaRepository.save(ratingCriteria);
    }

    @Override
    public void delete(Integer weight) {
        if(weight == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        ratingCriteriaRepository.deleteById(weight);
    }

    @Override
    public void delete(RatingCriteria ratingCriteria) {
        if (ratingCriteria == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        ratingCriteriaRepository.delete(ratingCriteria);
    }

    @Override
    public RatingCriteria update(RatingCriteria ratingCriteria) {
        if (ratingCriteria == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return ratingCriteriaRepository.saveAndFlush(ratingCriteria);
    }

    @Override
    public List<RatingCriteria> getAll() {
        return ratingCriteriaRepository.findAll();
    }

    @Override
    public RatingCriteria getByWeight(Integer weight) {
        if (weight == null) {
           throw new IllegalArgumentException("Parameter should not be null");
        }
        return (RatingCriteria) ratingCriteriaRepository.findByWeight(weight).orElseThrow(() -> new ResourceNotFoundException(String.format("RatingCriteria with id '%s' not found", weight)));
    }
}
