package com.example.demo.controller;

import com.example.demo.entity.dto.NonExtendableCategoryDTO;
import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.service.NonExtendableCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/NonExtendableCategory")
@CrossOrigin
@RequiredArgsConstructor
public class NonExtendableCategoryController {
    private final NonExtendableCategoryService nonExtendableCategoryService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/all/{up}")
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNextLevel(@PathVariable Integer up) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNextLevelCategory(up);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NonExtendableCategory> getCategoryById(@PathVariable Integer id) {

        NonExtendableCategory category = nonExtendableCategoryService.getById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NonExtendableCategory> addCategory(@RequestBody NonExtendableCategory nonExtendableCategory) {

        NonExtendableCategory category = nonExtendableCategoryService.addNonExtendableCategory(nonExtendableCategory);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        nonExtendableCategoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NonExtendableCategory> updateCategory(@RequestParam NonExtendableCategory nonExtendableCategory, @PathVariable Integer id) {
        NonExtendableCategory updatedCategory = nonExtendableCategoryService.update((NonExtendableCategory) nonExtendableCategory.setId(id));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(updatedCategory.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    //TODO take care about feedbackCriterias and chose one of getCategoryById methods
}
