package com.example.demo.controller;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Stop;
import com.example.demo.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("feedback/")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping(value = "getByFeedbackCriteria/{id}")
    public ResponseEntity<List<Feedback>> getByFeedbackCriteria(@PathVariable int id) {
        return new ResponseEntity<>(feedbackService.getByFeedbackCriteria(id), HttpStatus.OK);
    }

    @GetMapping(value = "getByTransit/{id}")
    public ResponseEntity<List<Feedback>> getByTransit(@PathVariable int id) {
        return new ResponseEntity<>(feedbackService.getByTransitId(id), HttpStatus.OK);
    }


    @GetMapping(value = "getById/{id}")
    public ResponseEntity<Optional<Feedback>> getById(@PathVariable int id) {
        return new ResponseEntity<>(feedbackService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<Feedback>> getAll() {
        return new ResponseEntity<>(feedbackService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Optional<Feedback>> add(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.addFeedback(feedback);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedFeedback.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        feedbackService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Feedback feedback, @PathVariable Integer id) {
        Optional<Feedback> feedbackOptional = feedbackService.getById(id);
        if (!feedbackOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        feedback.setId(id);
        feedbackService.update(feedback);
        return ResponseEntity.noContent().build();
    }

}
