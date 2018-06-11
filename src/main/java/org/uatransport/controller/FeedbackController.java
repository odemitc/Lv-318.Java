package org.uatransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.dto.FeedbackDTO;
import org.uatransport.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping(params = "criteriaId")
    public ResponseEntity<List<Feedback>> getByCriteria(@RequestParam("criteriaId") Integer criteriaId) {
        return new ResponseEntity<>(feedbackService.getByCriteriaId(criteriaId), HttpStatus.OK);
    }

    @GetMapping(params = "transitId")
    public ResponseEntity<List<Feedback>> getByTransit(@RequestParam("transitId") Integer transitId) {
        return new ResponseEntity<>(feedbackService.getByTransitId(transitId), HttpStatus.OK);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<List<Feedback>> getByUser(@RequestParam("userId") Integer userId) {
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

    @PostMapping(value = "/add")
    public ResponseEntity<List<Feedback>> addAll(@RequestBody List<FeedbackDTO> feedbackDTOList) {
        return new ResponseEntity<>(feedbackService.addAll(feedbackDTOList), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Feedback> add(@RequestBody FeedbackDTO feedbackDTO) {
        return new ResponseEntity<>(feedbackService.addFeedback(feedbackDTO), HttpStatus.CREATED);
    }

}