package com.example.demo.controller;

import com.example.demo.entity.RatingCriteria;
import com.example.demo.service.RatingCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequiredArgsConstructor
//@RequestMapping("/rating")
public class RatingCriteriaController {
    private final RatingCriteriaService ratingCriteriaService;

    public ResponseEntity<RatingCriteria> addRatingCriteria(@RequestBody RatingCriteria ratingCriteria) {
        return new ResponseEntity<>(ratingCriteriaService.save(ratingCriteria),HttpStatus.CREATED);
    }

    public void deleteRatingCriteria (@PathVariable Integer weight) {
        ratingCriteriaService.delete(weight);
    }

    public ResponseEntity<RatingCriteria> updateRatingCriteria(@RequestBody RatingCriteria ratingCriteria, @PathVariable Integer weight) {
        RatingCriteria updateRatingCriteria = ratingCriteriaService.update(ratingCriteria.setWeight(weight));
        return new ResponseEntity<>(ratingCriteriaService.update(ratingCriteria.setWeight(weight)), HttpStatus.OK);
    }





}
