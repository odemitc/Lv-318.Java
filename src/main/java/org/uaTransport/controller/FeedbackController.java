package org.uaTransport.controller;

import org.uaTransport.entity.Feedback;
import org.uaTransport.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping(value = "/criteria/{id}")
    public ResponseEntity<List<Feedback>> getByCriteria(@PathVariable Integer id) {
        return new ResponseEntity<>(feedbackService.getByCriteriaId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/transit/{id}")
    public ResponseEntity<List<Feedback>> getByTransit(@PathVariable Integer id) {
        return new ResponseEntity<>(feedbackService.getByTransitId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Feedback>> getByUser(@PathVariable Integer id) {
        return new ResponseEntity<>(feedbackService.getByUserId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feedback> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(feedbackService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Feedback> add(@RequestBody(required = false) Feedback feedback) {
        Feedback savedFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    @GetMapping(value ="/rate/{transitId}")
    public ResponseEntity<Double> getAverageRateByTransit(@PathVariable Integer transitId){
        return  new ResponseEntity<>(feedbackService.convertRatingFeedBacks(transitId), HttpStatus.OK);
    }



}