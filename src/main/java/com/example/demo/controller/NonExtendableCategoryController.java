package com.example.demo.controller;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.service.NonExtendableCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/NonExtendableCategory")
@RequiredArgsConstructor
public class NonExtendableCategoryController {
    private final NonExtendableCategoryService nonExtendableCategoryService;

    @GetMapping
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNextLevel(@RequestParam String up) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNextLevelCategory(nonExtendableCategoryService.getByName(up).getId());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NonExtendableCategory> getCategoryById(@PathVariable Integer id){

        NonExtendableCategory category = nonExtendableCategoryService.getById(id);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(location).build();
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
}
