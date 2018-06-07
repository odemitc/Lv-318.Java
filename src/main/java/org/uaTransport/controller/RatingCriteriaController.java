package org.uaTransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uaTransport.entity.RatingCriteria;
import org.uaTransport.service.RatingCriteriaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating-criteria")
public class RatingCriteriaController {
    private final RatingCriteriaService ratingCriteriaService;

    @PostMapping
    public ResponseEntity<RatingCriteria> addRatingCriteria(@RequestBody RatingCriteria ratingCriteria) {
        return new ResponseEntity<>(ratingCriteriaService.save(ratingCriteria), HttpStatus.CREATED);
    }

    @DeleteMapping("/{weight}")
    public void deleteRatingCriteria(@PathVariable Integer weight) {
        ratingCriteriaService.delete(weight);
    }

    @PutMapping("/{weight}")
    public ResponseEntity<RatingCriteria> updateRatingCriteria(@RequestBody RatingCriteria ratingCriteria,
                                                               @PathVariable Integer weight) {
        RatingCriteria updateRatingCriteria = ratingCriteriaService.update(ratingCriteria.setWeight(weight));
        return new ResponseEntity<>(ratingCriteriaService.update(ratingCriteria.setWeight(weight)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RatingCriteria>> getAllRatingCriteria() {
        return new ResponseEntity<>(ratingCriteriaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{weight}")
    public ResponseEntity<RatingCriteria> getByWeight(@PathVariable Integer weight) {
        return new ResponseEntity<>(ratingCriteriaService.getByWeight(weight), HttpStatus.OK);
    }
}
