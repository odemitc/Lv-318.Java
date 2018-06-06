package org.uaTransport.controller;

import org.uaTransport.entity.Transit;
import org.uaTransport.exception.ResourceNotFoundException;
import org.uaTransport.repository.NonExtendableCategoryRepository;
import org.uaTransport.service.TransitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transit")
@CrossOrigin
@RequiredArgsConstructor
public class TransitController {

    private final TransitService transitService;
    private final NonExtendableCategoryRepository nonExtendableCategoryRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Transit> getTransitById(@PathVariable Integer id) {
        return new ResponseEntity<>(transitService.getById(id), HttpStatus.OK);
    }

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

    @PostMapping
    public ResponseEntity<Transit> addTransit(@RequestBody Transit transit) {
        Transit savedTransit;
        Integer categoryId = transit.getCategory().getId();
        if (nonExtendableCategoryRepository.existsById(categoryId)) {
            savedTransit = transitService.addTransit(transit);
        } else {
            throw new ResourceNotFoundException(String.format("Category with id '%s' not found", categoryId));
        }

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