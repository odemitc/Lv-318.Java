package org.uaTransport.controller;

import org.uaTransport.entity.NonExtendableCategory;
import org.uaTransport.service.NonExtendableCategoryService;
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

    @GetMapping("/all")
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNextLevel(@RequestParam Integer up) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNextLevelCategory(up);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNames(@RequestParam String name, @RequestParam String next) {
        List<NonExtendableCategory> categories = nonExtendableCategoryService.getByNames(name, next);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NonExtendableCategory> getCategoryById(@PathVariable Integer id) {

        NonExtendableCategory category = nonExtendableCategoryService.getById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<NonExtendableCategory> addCategory(@RequestBody NonExtendableCategory nonExtendableCategory) {

        NonExtendableCategory category = nonExtendableCategoryService.addNonExtendableCategory(nonExtendableCategory);

        return new ResponseEntity<>(category, HttpStatus.OK);
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

        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
