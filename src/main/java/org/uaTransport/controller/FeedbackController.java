package org.uaTransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.dto.FeedbackDTO;
import org.uaTransport.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping(params = "id")
    public ResponseEntity<List<Feedback>> getByCriteria(@RequestParam Integer id) {
        return new ResponseEntity<>(feedbackService.getByCriteriaId(id), HttpStatus.OK);
    }

    @GetMapping(params = "transitId")
    public ResponseEntity<List<Feedback>> getByTransit(@RequestParam Integer transitId) {
        return new ResponseEntity<>(feedbackService.getByTransitId(transitId), HttpStatus.OK);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<List<Feedback>> getByUser(@RequestParam Integer userId) {
        return new ResponseEntity<>(feedbackService.getByUserId(userId), HttpStatus.OK);
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
    public ResponseEntity<List<Feedback>> add(@RequestBody List<FeedbackDTO> feedbackDTOList) {
        return new ResponseEntity<>(feedbackService.addAll(feedbackDTOList), HttpStatus.CREATED);
    }

}