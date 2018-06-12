package org.uatransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.service.FeedbackCriteriaService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/feedbackCriteria")
@CrossOrigin
public class FeedbackCriteriaController {
    private final FeedbackCriteriaService feedbackCriteriaService;


    @PostMapping
    public ResponseEntity<FeedbackCriteria> addFeedbackCriteria(@RequestBody FeedbackCriteria feedbackCriteria) {
        return new ResponseEntity<>(feedbackCriteriaService.save(feedbackCriteria), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedbackCriteria(@PathVariable Integer id) {
        feedbackCriteriaService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackCriteria> updateFeedbackCriteria(@RequestBody FeedbackCriteria feedbackCriteria, @PathVariable Integer id) {
        FeedbackCriteria updateFeedbackCriteria = feedbackCriteriaService.update(feedbackCriteria.setId(id));
        return new ResponseEntity<>(feedbackCriteriaService.update(feedbackCriteria.setId(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackCriteria>> getAllFeedbackCriteria() {
        return new ResponseEntity<>(feedbackCriteriaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackCriteria> getById(@PathVariable Integer id) {

        return new ResponseEntity<>(feedbackCriteriaService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<FeedbackCriteria>> getByType(@PathVariable(value = "type") FeedbackCriteria.FeedbackType type) {
        return new ResponseEntity<>(feedbackCriteriaService.getByType(type), HttpStatus.OK);
    }


    @GetMapping("/categoryId/{categoryId}")
    public ResponseEntity<List<FeedbackCriteria>> getByCategoryId(@PathVariable(value = "categoryId") Integer categoryId) {
        return new ResponseEntity<>(feedbackCriteriaService.getByCategoryId(categoryId), HttpStatus.OK);
    }


    @GetMapping("/questionId/{questionId}")
    public ResponseEntity<List<FeedbackCriteria>> getByQuestionsId(@PathVariable(value = "questionId") Integer questionId) {
        return new ResponseEntity<>(feedbackCriteriaService.getByQuestionsId(questionId), HttpStatus.OK);

    }

    @GetMapping("/groupId/{groupId}")
    public ResponseEntity<List<FeedbackCriteria>> getByGroupId(@PathVariable(value = "groupId") Integer groupId) {
        return new ResponseEntity<>(feedbackCriteriaService.getByQuestionsGroupId(groupId), HttpStatus.OK);
    }

    @GetMapping("/question/{question}")
    public ResponseEntity<List<FeedbackCriteria>> getByQuestions(@PathVariable(value = "question") String question) {
        return new ResponseEntity<>(feedbackCriteriaService.getByQuestionsName(question), HttpStatus.OK);
//нетягне
    }

    @GetMapping("/weight/{weight}")
    public ResponseEntity<List<FeedbackCriteria>> getByWeight(@PathVariable(value = "weight") Integer weight) {
        System.out.println(feedbackCriteriaService.getByWeight(weight));
        return new ResponseEntity<>(feedbackCriteriaService.getByWeight(weight), HttpStatus.OK);
//не тягне
    }
}
