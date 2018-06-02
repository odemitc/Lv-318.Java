package com.example.demo.controller;

import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.service.FeedbackCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/feedback-criteria")
public class FeedbackCriteriaController {
    private final FeedbackCriteriaService feedbackCriteriaService;


    @PostMapping
    public ResponseEntity<FeedbackCriteria> addFeedbackCriteria(@RequestBody FeedbackCriteria feedbackCriteria){
        return new ResponseEntity<>(feedbackCriteriaService.save(feedbackCriteria), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedbackCriteria(@PathVariable Integer id){
        feedbackCriteriaService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackCriteria> updateFeedbackCriteria(@RequestBody FeedbackCriteria feedbackCriteria, @PathVariable Integer id){
        FeedbackCriteria updateFeedbackCriteria = feedbackCriteriaService.update(feedbackCriteria.setId(id));
        return new ResponseEntity<>(feedbackCriteriaService.update(feedbackCriteria.setId(id)), HttpStatus.OK);
    }
    @GetMapping
    public  ResponseEntity<List<FeedbackCriteria>> getAllFeedbackCriteria() {
        return new ResponseEntity<>(feedbackCriteriaService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackCriteria> getById(@PathVariable Integer id){

        return new ResponseEntity<>(feedbackCriteriaService.getById(id).get(), HttpStatus.OK);
    }
    @GetMapping("/groupId/{groupId}")
    public ResponseEntity<List<FeedbackCriteria>> getByGroupId(@PathVariable(value = "groupId") Integer groupId){
        return new ResponseEntity<>(feedbackCriteriaService.getByGroupId(groupId), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<FeedbackCriteria>> getByType(@PathVariable (value = "type") FeedbackCriteria.FeedbackType type){
        return new ResponseEntity<>(feedbackCriteriaService.getByType(type), HttpStatus.OK);
    }
    @GetMapping("/question/{question}")
    public ResponseEntity<List<FeedbackCriteria>> getByQuestion(@PathVariable String question){
        return new ResponseEntity<>(feedbackCriteriaService.getByQuestion(question), HttpStatus.OK);
    }




}
