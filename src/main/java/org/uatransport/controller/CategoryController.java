package org.uatransport.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.config.SearchCategoryParam;
import org.uatransport.entity.ExtendableCategory;
import org.uatransport.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin // TODO: ADD FILTER !
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<ExtendableCategory> getCategoryById(@PathVariable Integer id) {

        ExtendableCategory category = categoryService.getById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    //TODO
    //    @GetMapping("/top")
    //    public ResponseEntity<List<ExtendableCategory>> getTopCategories() {
    //        return new ResponseEntity<>(categoryService.getListTopExtendableCategories(), HttpStatus.OK);
    //    }
    //
    //    @GetMapping("/all")
    //    public ResponseEntity<List<ExtendableCategory>> getCategoryByNextLevel(@RequestParam Integer up) {
    //        List<ExtendableCategory> categories = categoryService.getByNextLevelCategoryId(up);
    //
    //        return new ResponseEntity<>(categories, HttpStatus.OK);
    //    }
    //    @GetMapping("/get")
    //    public ResponseEntity<List<NonExtendableCategory>> getCategoryByNames(@RequestParam String name, @RequestParam String next) {
    //        List<NonExtendableCategory> categories = categoryService.getByNames(name, next);
    //        return new ResponseEntity<>(categories, HttpStatus.OK);
    //    }
    //
    @GetMapping
    public ResponseEntity<List<ExtendableCategory>> search(SearchCategoryParam searchCategoryParam) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExtendableCategory> save(@RequestBody ExtendableCategory category) {
        ExtendableCategory savedCategory = categoryService.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExtendableCategory> update(@RequestBody ExtendableCategory category, @PathVariable Integer id) {
        ExtendableCategory updatedCategory = categoryService.update(category.setId(id));
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
