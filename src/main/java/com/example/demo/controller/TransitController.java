package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.entity.Transit;
import com.example.demo.service.TransitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/transit")
@RequiredArgsConstructor
public class TransitController {

    private final TransitService transitService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Transit> getTransitById(@PathVariable Integer id) {
        return new ResponseEntity<>(transitService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Transit>> getAllTransits() {
        return new ResponseEntity<>(transitService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<Transit>> getTransitsByCategoryId(@PathVariable Integer category_id) {
        return new ResponseEntity<>(transitService.getAllByCategoryId(category_id), HttpStatus.OK);
    }

    @GetMapping("/category/")
    public ResponseEntity<List<Transit>> getTransitsByCategoryName(@RequestParam String categoryName) {
        return new ResponseEntity<>(transitService.getAllByCategoryName(categoryName), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Transit> addTransit(@RequestBody Transit transit) {
        Transit savedTransit = transitService.addTransit(transit);
        return new ResponseEntity<>(savedTransit, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTransit(@PathVariable Integer id) {
        transitService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transit> updateTransit(@RequestBody Transit transit, @PathVariable Integer id) {
        Transit updatedTransit = transitService.update(transit.setId(id));
        return new ResponseEntity<>(updatedTransit, HttpStatus.OK);
    }

}