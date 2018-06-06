package org.uaTransport.controller;

import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;
import org.uaTransport.entity.User;
import org.uaTransport.entity.dto.FeedbackDTO;
import org.uaTransport.service.FeedbackCriteriaService;
import org.uaTransport.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uaTransport.service.TransitService;
import org.uaTransport.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final FeedbackCriteriaService feedbackCriteriaService;
    private final UserService userService;
    private final TransitService transitService;

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

    @GetMapping(value = "/rate/{transitId}")
    public ResponseEntity<Double> getAverageRateByTransit(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.convertRatingFeedBacks(transitId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Feedback> addDTO(@RequestBody FeedbackDTO feedbackDTO) {
        return new ResponseEntity<>(feedbackService.addFeedback(feedbackDTO.toEntity()),
                HttpStatus.CREATED);
    }
}