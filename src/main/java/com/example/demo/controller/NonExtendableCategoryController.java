package com.example.demo.controller;

import com.example.demo.entity.ExtendableCategory;
import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.service.NonExtendableCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NonExtendableCategory")
@CrossOrigin
@RequiredArgsConstructor
public class NonExtendableCategoryController {
    private final NonExtendableCategoryService nonExtendableCategoryService;
//    private final NonExtendableCategoryService extendableCategoryService;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNextLevel(@RequestParam Integer up) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNextLevelCategory(up);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNames(@RequestParam String name, @RequestParam String next) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNames(name, next);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<NonExtendableCategory> getCategoryById(@PathVariable Integer id) {

        NonExtendableCategory category = nonExtendableCategoryService.getById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<NonExtendableCategory> addCategory(@RequestBody NonExtendableCategory nonExtendableCategory) {

        NonExtendableCategory category = nonExtendableCategoryService.addNonExtendableCategory(nonExtendableCategory);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

//    @PostMapping("/add/")
//    public ResponseEntity<NonExtendableCategory> addCategory(@RequestParam("name") String name, @RequestParam("id") Integer id) {
//
//        NonExtendableCategory nonExtendableCategory = new NonExtendableCategory();
//        nonExtendableCategory.setName(name).setNextLevelCategory(extendableCategoryService.getById(id));
//
//        NonExtendableCategory category = nonExtendableCategoryService.addNonExtendableCategory(nonExtendableCategory);
//
//        return new ResponseEntity<>(category, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        nonExtendableCategoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NonExtendableCategory> updateCategory(@RequestParam NonExtendableCategory nonExtendableCategory, @PathVariable Integer id) {
        NonExtendableCategory updatedCategory = nonExtendableCategoryService.update((NonExtendableCategory) nonExtendableCategory.setId(id));

        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
