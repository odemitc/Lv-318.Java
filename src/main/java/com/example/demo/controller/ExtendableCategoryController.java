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

    @GetMapping
    public ResponseEntity<List<ExtendableCategory>> getTopCategories() {
        return new ResponseEntity<>(categoryService.getListTopExtendableCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{top}")
    public ResponseEntity<List<ExtendableCategory>> getMiddleCategories(@PathVariable String top) {
        return new ResponseEntity<>(categoryService.getByNextLevelCategoryId(categoryService.getByName(top).getId()), HttpStatus.OK);
    }

    @GetMapping(value = "/{top}/{next}/")
    public ResponseEntity<List<ExtendableCategory>> getLastCategories(@PathVariable String top, @PathVariable String next) {
        ExtendableCategory topCategory = categoryService.getByName(top);
        ExtendableCategory nextCategory = categoryService.getByNameAndNextLevelCategory(next, topCategory);
        return new ResponseEntity<>(categoryService.getByNextLevelCategory(nextCategory), HttpStatus.OK);
    }
}
