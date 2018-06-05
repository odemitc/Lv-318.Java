package com.example.demo.controller;

import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping(value = "/criteria/{id}")
    public ResponseEntity<List<Feedback>> getByCriteria(@RequestParam("criteriaId") Integer id) {
        return new ResponseEntity<>(feedbackService.getByCriteriaId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getByTransit(@RequestParam("transitId") Integer id) {
        return new ResponseEntity<>(feedbackService.getByTransitId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Feedback>> getByUser(@RequestParam("userId") Integer id) {
        return new ResponseEntity<>(feedbackService.getByUserId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feedback> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(feedbackService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Feedback> add(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.addFeedback(feedback);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedFeedback.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}