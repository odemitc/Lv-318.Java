package org.uatransport.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.Stop;
import org.uatransport.entity.dto.FeedbackDTO;
import org.uatransport.service.FeedbackService;
import org.uatransport.service.converter.model.AccepterFeedback;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
  private final FeedbackService feedbackService;

  @GetMapping(params = "criteriaId")
  public ResponseEntity<List<Feedback>> getByCriteria(
      @RequestParam("criteriaId") Integer criteriaId) {
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

  @GetMapping(value = "/rate/{transitId}")
  public ResponseEntity<Double> getAverageRateByTransit(@PathVariable Integer transitId) {
    return new ResponseEntity<>(
        feedbackService.getAverageRateByTransitId(transitId), HttpStatus.OK);
  }

  @GetMapping(value = "/rate/{transitId}/{userId}")
  public ResponseEntity<Double> getAverageRateByTransitAndUser(
      @PathVariable Integer transitId, @PathVariable Integer userId) {
    return new ResponseEntity<>(
        feedbackService.getAverageRateByTransitAndUser(transitId, userId), HttpStatus.OK);
  }

  @GetMapping(value = "/byHour/{transitId}")
  public ResponseEntity<Map<Integer, Double>> getCapacityHoursMap(@PathVariable Integer transitId) {
    return new ResponseEntity<>(feedbackService.getHourCapacityMap(transitId), HttpStatus.OK);
  }

  @GetMapping(value = "/byStop/{transitId}")
  public ResponseEntity<Map<Stop, Double>> getCapacityStopMap(
      @PathVariable Integer transitId,
      @RequestParam(value = "stopList[]", required = false) List<Stop> stopList) {
    Stop[] stopsVarArg = stopList.toArray(new Stop[stopList.size()]);
    return new ResponseEntity<>(
        feedbackService.getStopCapacityMap(transitId, stopsVarArg), HttpStatus.OK);
  }

  @GetMapping(value = "/accepterMap/{transitId}")
  public ResponseEntity<EnumMap<AccepterFeedback, Double>> getAccepterMap(
      @PathVariable Integer transitId) {
    return new ResponseEntity<>(
        feedbackService.getAccepterAnswerPercentageMap(transitId), HttpStatus.OK);
  }
}
