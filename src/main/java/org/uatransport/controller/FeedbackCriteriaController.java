package org.uatransport.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.entity.Question;
import org.uatransport.service.FeedbackCriteriaService;
import org.uatransport.service.QuestionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedback-criteria")
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
    public FeedbackCriteria updateFeedbackCriteria(@RequestBody FeedbackCriteria feedbackCriteria, @PathVariable Integer id) {
        return feedbackCriteriaService.update(feedbackCriteria.setId(id));
    }

    @GetMapping
    public ResponseEntity<List<FeedbackCriteria>> getAllFeedbackCriteria() {

        return new ResponseEntity<>(feedbackCriteriaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public FeedbackCriteria getById(@PathVariable Integer id) {
        return feedbackCriteriaService.getById(id);
    }

    @GetMapping("/type/{type}")
    public List<FeedbackCriteria> getByType(@PathVariable(value = "type") FeedbackCriteria.FeedbackType type) {
        return feedbackCriteriaService.getByType(type);
    }


    @GetMapping("/categoryId/{categoryId}")
    public List<FeedbackCriteria> getByCategoryId(@PathVariable(value = "categoryId") Integer categoryId) {
        return feedbackCriteriaService.getByCategoryId(categoryId);
    }


    @GetMapping("/questionId/{questionId}")
    public List<FeedbackCriteria> getByQuestionsId(@PathVariable(value = "questionId") Integer questionId) {
        return feedbackCriteriaService.getByQuestionsId(questionId);

    }

    @GetMapping("/question/{question}")
    public List<FeedbackCriteria> getByQuestions(@PathVariable(value = "question") String question) {
        return feedbackCriteriaService.getByQuestionsName(question);
    }

    @GetMapping("/weight/{weight}")
    public List<FeedbackCriteria> getByWeight(@PathVariable(value = "weight") Integer weight) {
        return feedbackCriteriaService.getByWeight(weight);

    }
    @GetMapping("/categoryId/{categoryId}/type/{type}")
    public List<FeedbackCriteria> getByTypeAndCategoryId(@PathVariable(value = "categoryId") Integer categoryId, @PathVariable(value = "type")String type){
        return feedbackCriteriaService.getByTypeAndCategoryId(categoryId, type);
    }
}
