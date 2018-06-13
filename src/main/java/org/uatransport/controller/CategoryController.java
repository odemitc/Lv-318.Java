package org.uatransport.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uatransport.config.SearchCategoryParam;
import org.uatransport.config.SearchSpecification;
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

    @GetMapping
    public ResponseEntity<List<ExtendableCategory>> search(SearchCategoryParam searchCategoryParam) {
        SearchSpecification specification = new SearchSpecification(searchCategoryParam);

        return new ResponseEntity<>(categoryService.getAll(specification), HttpStatus.OK);
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
