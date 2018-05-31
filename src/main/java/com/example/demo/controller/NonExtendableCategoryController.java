package com.example.demo.controller;

import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.service.NonExtendableCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NonExtendableCategory")
@RequiredArgsConstructor
public class NonExtendableCategoryController {
    private final NonExtendableCategoryService nonExtendableCategoryService;

    @GetMapping("/")
    public ResponseEntity<List<NonExtendableCategory>> getAllCategories(){
        return new ResponseEntity<>(nonExtendableCategoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<NonExtendableCategory> getCategoryByNextLevel(@RequestParam String up) {
        return new ResponseEntity<NonExtendableCategory>(nonExtendableCategoryService.getByNextLevelCategory(nonExtendableCategoryService.getByName(up).getId()),
                HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NonExtendableCategory> addCategory(@RequestBody NonExtendableCategory nonExtendableCategory) {
        NonExtendableCategory category = nonExtendableCategoryService.addNonExtendableCategory(nonExtendableCategory);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        nonExtendableCategoryService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NonExtendableCategory> updateCategory(@RequestParam NonExtendableCategory nonExtendableCategory, @PathVariable Integer id) {
        NonExtendableCategory updatedCategory = nonExtendableCategoryService.update((NonExtendableCategory) nonExtendableCategory.setId(id));

        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
