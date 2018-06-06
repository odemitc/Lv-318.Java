package org.uaTransport.controller;


import org.uaTransport.entity.ExtendableCategory;
import org.uaTransport.service.ExtendebleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
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

    @GetMapping("/{name}")
    public ResponseEntity<ExtendableCategory> getCategoryByName(@PathVariable String name) {
        return new ResponseEntity<>(categoryService.getByName(name), HttpStatus.OK);
    }

    @PostMapping
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
