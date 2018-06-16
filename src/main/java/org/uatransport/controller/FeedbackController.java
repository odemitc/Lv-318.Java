package org.uatransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.dto.FeedbackDTO;
import org.uatransport.service.FeedbackService;
import org.uatransport.service.model.AccepterFeedback;
import org.uatransport.service.model.CapacityFeedback;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
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


    @PostMapping(value = "/add")
    public ResponseEntity<List<Feedback>> addAll(@RequestBody List<FeedbackDTO> feedbackDTOList) {
        return new ResponseEntity<>(feedbackService.addAll(feedbackDTOList), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Feedback> add(@RequestBody FeedbackDTO feedbackDTO) {
        return new ResponseEntity<>(feedbackService.addFeedback(feedbackDTO), HttpStatus.CREATED);
    }

    //For average rate
    @GetMapping(value = "/rate/{transitId}")
    public ResponseEntity<Double> getAverageRateByTransit(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.convertRatingFeedBacks(transitId), HttpStatus.OK);
    }

    //For statistic average rate
    @GetMapping(value = "/rate/{transitId}/{userId}")
    public ResponseEntity<Double> getAverageRateByTransitAndUser(@PathVariable Integer transitId, @PathVariable Integer userId) {
        return new ResponseEntity<>(feedbackService.convertRatingFeedBacksByUser(transitId, userId), HttpStatus.OK);
    }


    @GetMapping(value = "/capacity/{transitId}")
    public ResponseEntity<List<CapacityFeedback>> getCapacityFeedBacks(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.convertCapacityFeedBacks(transitId), HttpStatus.OK);
    }

    @GetMapping(value = "/accepter/{transitId}")
    public ResponseEntity<List<AccepterFeedback>> getAccepterFeedBacks(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.convertAccepterFeedBacks(transitId), HttpStatus.OK);
    }

    //For busy hours diagram
    @GetMapping(value = "/byHour/{transitId}")
    public ResponseEntity<Map<Integer, Double>> getCapacityHoursMap(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.getDataForCapacityHoursDiagram(transitId), HttpStatus.OK);
    }

    //For busy hours diagram mapped by stops
    @GetMapping(value = "/byStop/{transitId}")
    public ResponseEntity<Map<String, Double>> getCapacityStopMap(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.getDataForCapacityStopDiagram(transitId), HttpStatus.OK);
    }

    //For rating diagram
    @GetMapping(value = "/accepterMap/{transitId}")
    public ResponseEntity<EnumMap<AccepterFeedback, Double>> getAccepterMap(@PathVariable Integer transitId) {
        return new ResponseEntity<>(feedbackService.getDataForAccepterDiagram(transitId), HttpStatus.OK);
    }
}