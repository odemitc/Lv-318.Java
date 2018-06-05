package com.example.demo.controller;


import com.example.demo.entity.ExtendableCategory;
import com.example.demo.service.ExtendebleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class ExtendableCategoryController {
    private final ExtendebleCategoryService categoryService;

    @GetMapping("/top/")
    public ResponseEntity<List<ExtendableCategory>> getTopCategories() {
        return new ResponseEntity<>(categoryService.getListTopExtendableCategories(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExtendableCategory>> getCategoriesByNextLevel(@RequestParam String top) {
        return new ResponseEntity<>(categoryService.getByNextLevelCategoryId(categoryService.getByName(top).getId()), HttpStatus.OK);
    }
//
//    @GetMapping
//    public ResponseEntity<List<ExtendableCategory>> getLastCategories(@RequestParam String top, @RequestParam String next) {
//        ExtendableCategory topCategory = categoryService.getByName(top);
//        ExtendableCategory nextCategory = categoryService.getByNameAndNextLevelCategory(next, topCategory);
//        return new ResponseEntity<>(categoryService.getByNextLevelCategory(nextCategory), HttpStatus.OK);
//    }

    @PostMapping()
    public ResponseEntity<ExtendableCategory> addTransit(@RequestBody ExtendableCategory category) {
        ExtendableCategory savedCategory = categoryService.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTransit(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtendableCategory> updateCategory(@RequestBody ExtendableCategory category, @PathVariable Integer id) {
        ExtendableCategory updatedCategory = categoryService.update(category.setId(id));
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
